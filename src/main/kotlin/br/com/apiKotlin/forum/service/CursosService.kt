package br.com.apiKotlin.forum.service

import br.com.apiKotlin.forum.model.Curso
import br.com.apiKotlin.forum.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursosService(private var repository: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repository.getOne(id)

    }
}