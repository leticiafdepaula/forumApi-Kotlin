package br.com.apiKotlin.forum.controller

import br.com.apiKotlin.forum.model.StatusTopico
import java.time.LocalDateTime

data class TopicoView(
        val id: Long?,
        val titulo: String,
        val mensagem: String,
        val status: StatusTopico,
        val dataCriacao: LocalDateTime
)
