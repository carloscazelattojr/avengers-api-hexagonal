package br.com.carlosjunior.avengersapi.application.web.resource.request

import br.com.carlosjunior.avengersapi.domain.avanger.Avenger
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty

data class AvengerRequest(

        @field:NotBlank
        @field:NotBlank
        @field:NotEmpty
        val nick: String,

        @field:NotBlank
        @field:NotBlank
        @field:NotEmpty
        val person: String,

        val description: String? = "",

        val history: String? = ""
) {
    fun toAvenger() = Avenger(
            nick = nick,
            person = person,
            description = description,
            history = history
    )

    companion object {
        fun to(id: Long?, request: AvengerRequest) = Avenger(
                id = id,
                nick = request.nick,
                person = request.person,
                description = request.description,
                history = request.history
        )
    }
}
