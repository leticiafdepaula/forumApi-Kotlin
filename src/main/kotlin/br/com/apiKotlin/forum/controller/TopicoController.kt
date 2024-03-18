package br.com.apiKotlin.forum.controller

import br.com.apiKotlin.forum.model.Topico
import br.com.apiKotlin.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping ("/topicos")
class TopicoController (private val service: TopicoService){
    @GetMapping
    fun listar(): List<Topico> {
      return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Topico {
              return service.buscarPorId(id)
    }
    @PostMapping
    fun cadastrar(@RequestBody topico: Topico) {
        service.cadastrar(topico)

    }


}