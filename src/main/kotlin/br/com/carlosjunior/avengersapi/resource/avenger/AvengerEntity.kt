package br.com.carlosjunior.avengersapi.resource.avenger

import br.com.carlosjunior.avengersapi.domain.avanger.Avenger
import jakarta.persistence.*

@Entity
data class AvengerEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        @Column(nullable = false)
        val nick: String,
        @Column(nullable = false)
        val person: String,
        val description: String?,
        val history: String?
) {
        fun toAvenger() = Avenger(id, nick, person, description, history)

        companion object {
                fun from(avenger: Avenger) = AvengerEntity(
                        id = avenger.id,
                        nick = avenger.nick,
                        description = avenger.description,
                        person = avenger.person,
                        history = avenger.history
                )
        }
}
