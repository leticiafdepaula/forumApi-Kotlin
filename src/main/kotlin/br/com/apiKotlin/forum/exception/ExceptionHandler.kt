package br.com.apiKotlin.forum.exception

import br.com.apiKotlin.forum.dto.ErrorView
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import kotlin.math.exp

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handlerNotFound(
            exception: NotFoundException,
            request: HttpServletRequest
    ): ErrorView {
        return ErrorView(
                status = HttpStatus.NOT_FOUND.value(),
                error =  HttpStatus.NOT_FOUND.name,
                message = exception.message,
                path = request.servletPath

        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handlerValidationError(
            exception: MethodArgumentNotValidException,
            request: HttpServletRequest
    ): ErrorView {
       val errorMessage = HashMap<String, String?>()
        exception.bindingResult.fieldErrors.forEach{
            e -> errorMessage.put(e.field, e.defaultMessage)
        }

        return ErrorView(
                status = HttpStatus.BAD_REQUEST.value(),
                error =  HttpStatus.BAD_REQUEST.name,
                message = errorMessage.toString(),
                 path = request.servletPath
        )
    }


    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handlerServerError(
            exception: NotFoundException,
            request: HttpServletRequest
    ): ErrorView {
        return ErrorView(
                status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                error =  HttpStatus.INTERNAL_SERVER_ERROR.name,
                message = exception.message,
                path = request.servletPath

        )
    }

}