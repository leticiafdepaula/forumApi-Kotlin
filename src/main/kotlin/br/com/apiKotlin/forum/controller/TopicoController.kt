package br.com.apiKotlin.forum.controller

import br.com.apiKotlin.forum.dto.AtualizacaoTopicoForm
import br.com.apiKotlin.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping ("/topicos")
class TopicoController (private val service: TopicoService){
    @GetMapping
    fun listar(): List<TopicoView> {
      return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
              return service.buscarPorId(id)
    }
    @PostMapping
    fun cadastrar(@RequestBody @Valid form: NovoTopicoForm) {
        service.cadastrar(form)

    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm) {
         service.atualizar(form)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
      service.deletar(id)
    }
}