package br.com.apiKotlin.forum.service

import br.com.apiKotlin.forum.mapper.TopicoFormMapper
import br.com.apiKotlin.forum.mapper.TopicoViewMapper
import br.com.apiKotlin.forum.model.TopicoTest
import br.com.apiKotlin.forum.repository.TopicoRepository
import io.mockk.every
import io.mockk.mockk
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Service

@Service
class TopicoServiceTest {

    val topico = PageImpl(listOf(TopicoTest.build()))
    val topicoRepository: TopicoRepository = mockk{
        every { findByCursoNome(any(), any()) } returns topico
    }

    val topicoViewMapper: TopicoViewMapper = mockk()
    val topicoFormMapper: TopicoFormMapper  = mockk()


    val topicoService = TopicoService (
        topicoRepository, topicoViewMapper,topicoFormMapper

    )

}







