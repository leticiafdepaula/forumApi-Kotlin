package br.com.apiKotlin.forum.mapper

import br.com.apiKotlin.forum.model.Topico
import br.com.apiKotlin.forum.controller.TopicoView
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoView>  {

       override fun map(t: Topico): TopicoView {
           return TopicoView(
                   id = t.id,
                   titulo = t.titulo,
                   mensagem = t.mensagem,
                   dataCriacao = t.dataCriacao,
                   status = t.status
           )
       }
    }
