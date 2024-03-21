package br.com.apiKotlin.forum.repository

import br.com.apiKotlin.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long> {
}