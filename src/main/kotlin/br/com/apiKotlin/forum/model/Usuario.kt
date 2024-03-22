package br.com.apiKotlin.forum.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Usuario (
        @Id
        val id: Long? = null,
        val nome: String,
        val email: String

)


