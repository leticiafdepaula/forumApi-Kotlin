package br.com.apiKotlin.forum.service

import br.com.apiKotlin.forum.model.Usuario
import br.com.apiKotlin.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService (private val repository: UsuarioRepository ) {
    fun buscarPorId(id: Long): Usuario {
        return repository.getOne(id)
    }

}