package br.com.apiKotlin.forum.service

import br.com.apiKotlin.forum.controller.NovoTopicoForm
import br.com.apiKotlin.forum.controller.TopicoView
import br.com.apiKotlin.forum.dto.AtualizacaoTopicoForm
import br.com.apiKotlin.forum.exception.NotFoundException
import br.com.apiKotlin.forum.mapper.TopicoFormMapper
import br.com.apiKotlin.forum.mapper.TopicoViewMapper
import br.com.apiKotlin.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import javax.annotation.processing.Messager
import kotlin.collections.ArrayList

@Service
class TopicoService (
        private var topicos: List<Topico> = ArrayList(),
        private val topicoViewMapper: TopicoViewMapper,
        private val topicoformMapper: TopicoFormMapper,
       private val notFoundMessage: String = "Topico não encontrado!"
        ) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map {
            t -> topicoViewMapper.map(t)
         }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
          val topico = topicos.stream().filter { t ->
              t.id == id
          }.findFirst().get()
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoformMapper.map(form)
        topico.id = topicos.size.toLong() +1
           topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()
        val topicoAtualizado = Topico(
                        id = form.id,
                        titulo = form.titulo,
                        mensagem = form.mensagem,
                        autor = topico.autor,
                        curso = topico.curso,
                        respostas = topico.respostas,
                        status = topico.status,
                        dataCriacao = topico.dataCriacao
                )
        topicos = topicos.minus(topico).plus(topicoAtualizado)
        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        topicos = topicos.minus(topico)
    }
}

