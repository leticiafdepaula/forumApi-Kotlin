package br.com.apiKotlin.forum.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
data class Resposta (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val mensagem: String,
        val dataCriacao: LocalDateTime = LocalDateTime.now(),
        val autor: Usuario,
        @ManyToOne
        val topico: Topico,
        val solucao: Boolean
)

