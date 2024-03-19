package br.com.apiKotlin.forum.service

import br.com.apiKotlin.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class CursosService(var cursos: List<Curso>) {

    init {
         val curso = Curso(
                 id = 1,
                 nome = "Kotlin",
                 categoria = "Programacao"
         )
         cursos = Arrays.asList(curso)
     }


    fun buscarPorId(id: Long): Curso {
         return cursos.stream().filter({
             c -> c.id == id
         }).findFirst().get()
    }

}
