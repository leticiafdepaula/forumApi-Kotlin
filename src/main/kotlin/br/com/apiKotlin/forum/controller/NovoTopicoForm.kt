package br.com.apiKotlin.forum.controller

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NovoTopicoForm (
        @field:NotEmpty
        @field:Size(min = 10, max = 100)
        val titulo: String,
        @field:NotEmpty
        val mensagem: String,
        @field:NotNull
        val idCurso: Long,
        @field:NotNull
        val idAutor: Long
)
