package br.com.apiKotlin.forum.service

import br.com.apiKotlin.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (var usuarios: List<Usuario>) {

    init {
        val usuario = Usuario(
                id = 1,
                nome = "Leticia Ferreira",
                email = "leticiaferreira150998@gmail.com"
        )
        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter({
            c -> c.id == id
        }).findFirst().get()
    }

}