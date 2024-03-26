package br.com.apiKotlin.forum.service

import br.com.apiKotlin.forum.controller.NovoTopicoForm
import br.com.apiKotlin.forum.controller.TopicoView
import br.com.apiKotlin.forum.dto.AtualizacaoTopicoForm
import br.com.apiKotlin.forum.exception.NotFoundException
import br.com.apiKotlin.forum.mapper.TopicoFormMapper
import br.com.apiKotlin.forum.mapper.TopicoViewMapper
import br.com.apiKotlin.forum.repository.TopicoRepository
import jakarta.persistence.EntityManager
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import java.awt.print.Pageable

@Service
class TopicoService (
        private val repository: TopicoRepository,
        private val topicoViewMapper: TopicoViewMapper,
        private val topicoformMapper: TopicoFormMapper,
        private val notFoundMessage: String = "Topico não encontrado!",
        private val em: EntityManager
        ) {

    fun listar(nomeCurso: String?,
               pagina: Pageable
       ): Page<TopicoView> {
        val topicos = if (nomeCurso == null) {
            repository.findAll(pagina)
        } else {
            repository.findByCursoNome(nomeCurso, pagina)
        }
        return topicos.map { t ->
            topicoViewMapper.map(t)
         }
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

