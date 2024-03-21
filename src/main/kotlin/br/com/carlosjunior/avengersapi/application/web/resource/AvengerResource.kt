package br.com.carlosjunior.avengersapi.application.web.resource

import br.com.carlosjunior.avengersapi.application.web.resource.request.AvengerRequest
import br.com.carlosjunior.avengersapi.application.web.resource.response.AvengerResponse
import br.com.carlosjunior.avengersapi.domain.avanger.AvengerRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

private const val API_PATH ="/v1/api/avenger"

@RestController
@RequestMapping(value = [API_PATH])
class AvengerResource(
        @Autowired private val repository: AvengerRepository
) {

    @GetMapping
    fun getAvengers(): ResponseEntity<List<AvengerResponse>> =
            repository.getAvengers()
                    .map { AvengerResponse.from(it) }
                    .let {
                        ResponseEntity.ok().body(it)
                    }

    @GetMapping("{id}")
    fun getAvengerDetails(@PathVariable("id") id: Long) =
            repository.getDetail(id).let {
                ResponseEntity.ok().body(AvengerResponse.from(it))
            }


    fun createAvenger(@Valid @RequestBody request: AvengerRequest) =
            request.toAvenger()
                    .run {
                        repository.create(this)
                    }
                    .let {
                        ResponseEntity
                                .created(URI("$API_PATH/${it.id}"))
                                .body(AvengerResponse.from(it))
                    }

}