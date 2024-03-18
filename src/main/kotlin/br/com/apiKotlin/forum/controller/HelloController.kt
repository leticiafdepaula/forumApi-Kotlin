package br.com.apiKotlin.forum.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class helloController {

    @GetMapping
    fun hello(): String {
        return "alterado"
    }

}