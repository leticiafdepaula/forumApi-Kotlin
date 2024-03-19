package br.com.apiKotlin.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}