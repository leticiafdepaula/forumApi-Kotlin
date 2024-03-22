package br.com.apiKotlin.forum.repository

import br.com.apiKotlin.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {

    fun findByCursoNome(nomeCurso: String): List<Topico>
}