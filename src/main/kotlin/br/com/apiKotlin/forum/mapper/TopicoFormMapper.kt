package br.com.apiKotlin.forum.mapper

import br.com.apiKotlin.forum.controller.NovoTopicoForm
import br.com.apiKotlin.forum.model.Topico
import br.com.apiKotlin.forum.service.CursosService
import br.com.apiKotlin.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
        private val cursoService: CursosService,
        private val usuarioService: UsuarioService
      ): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
                titulo = t.titulo,
                mensagem = t.mensagem,
                curso = cursoService.buscarPorId(t.idCurso),
                autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}