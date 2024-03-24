package br.com.apiKotlin.forum.repository

import br.com.apiKotlin.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import java.awt.print.Pageable

interface TopicoRepository: JpaRepository<Topico, Long> { 
    fun findByCursoNome(nomeCurso: String, pagina: Pageable): Page<Topico>
    abstract fun findAll(pagina: Pageable): Page<Topico>

}

