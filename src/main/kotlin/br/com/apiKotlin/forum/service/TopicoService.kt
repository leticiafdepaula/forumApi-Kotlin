package br.com.apiKotlin.forum.service

import br.com.apiKotlin.forum.controller.NovoTopicoForm
import br.com.apiKotlin.forum.controller.TopicoView
import br.com.apiKotlin.forum.dto.AtualizacaoTopicoForm
import br.com.apiKotlin.forum.exception.NotFoundException
import br.com.apiKotlin.forum.mapper.TopicoFormMapper
import br.com.apiKotlin.forum.mapper.TopicoViewMapper
import br.com.apiKotlin.forum.model.Topico
import br.com.apiKotlin.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import javax.annotation.processing.Messager
import kotlin.collections.ArrayList

@Service
class TopicoService (
        private val repository: TopicoRepository,
        private val topicoViewMapper: TopicoViewMapper,
        private val topicoformMapper: TopicoFormMapper,
       private val notFoundMessage: String = "Topico não encontrado!"
        ) {

    fun listar(): List<TopicoView> {
        return repository.findAll().stream().map {
            t -> topicoViewMapper.map(t)
         }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
          val topico = repository.findById(id)
               .orElseThrow{NotFoundException(notFoundMessage)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoformMapper.map(form)
       repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findById(form.id).orElseThrow{NotFoundException(notFoundMessage)}
       topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
      repository.deleteById(id)
    }
}

