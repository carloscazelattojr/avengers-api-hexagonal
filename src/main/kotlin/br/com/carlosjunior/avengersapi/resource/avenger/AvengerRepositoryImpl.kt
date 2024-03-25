package br.com.carlosjunior.avengersapi.resource.avenger

import br.com.carlosjunior.avengersapi.domain.avanger.Avenger
import br.com.carlosjunior.avengersapi.domain.avanger.AvengerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class AvengerRepositoryImpl(
    @Autowired private val repository: AvengerEntityRepository
) : AvengerRepository {
    override fun getDetail(id: Long): Avenger? = repository.findByIdOrNull(id)?.toAvenger()

    override fun getAvengers(): List<Avenger> = repository.findAll().map { it.toAvenger() }

    override fun create(avenger: Avenger): Avenger = repository.save(AvengerEntity.from(avenger)).toAvenger();

    override fun delete(id: Long) = repository.deleteById(id);

    override fun update(avenger: Avenger): Avenger = repository.save(AvengerEntity.from(avenger)).toAvenger();
}