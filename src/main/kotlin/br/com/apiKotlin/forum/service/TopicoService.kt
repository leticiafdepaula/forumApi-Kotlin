package br.com.apiKotlin.forum.service

import br.com.apiKotlin.forum.controller.NovoTopicoForm
import br.com.apiKotlin.forum.controller.TopicoView
import br.com.apiKotlin.forum.dto.AtualizacaoTopicoForm
import br.com.apiKotlin.forum.mapper.TopicoFormMapper
import br.com.apiKotlin.forum.mapper.TopicoViewMapper
import br.com.apiKotlin.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService (
        private var topicos: List<Topico> = ArrayList(),
        private val topicoViewMapper: TopicoViewMapper,
        private val topicoformMapper: TopicoFormMapper
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

    fun cadastrar(form: NovoTopicoForm) {
        val topico = topicoformMapper.map(form)
        topico.id = topicos.size.toLong() +1
           topicos = topicos.plus(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm) {
        val topico = topicos.stream().filter { t ->
            t.id == form.id
        }.findFirst().get()
        topicos = topicos.minus(topico).plus(Topico (
                      id = form.id,
                titulo = form.titulo,
                mensagem = form.mensagem,
                autor = topico.autor,
                curso = topico.curso,
                respostas = topico.respostas,
                status = topico.status,
                dataCriacao = topico.dataCriacao
        ))
    }
}

