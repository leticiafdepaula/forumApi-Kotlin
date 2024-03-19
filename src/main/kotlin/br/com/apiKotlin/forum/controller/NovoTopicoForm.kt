package br.com.apiKotlin.forum.controller

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NovoTopicoForm (
        @field:NotEmpty
        @field:Size(min = 10, max = 100, message = "Titulo deve ter entre 5 á 100 caracter")
        val titulo: String,
        @field:NotEmpty
        @field:Size(message = "mensagem não pode ser em branco")
        val mensagem: String,
        @field:NotNull
        val idCurso: Long,
        @field:NotNull
        val idAutor: Long
)
