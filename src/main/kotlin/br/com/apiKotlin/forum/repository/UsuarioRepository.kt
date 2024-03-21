package br.com.apiKotlin.forum.repository

import br.com.apiKotlin.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {
}