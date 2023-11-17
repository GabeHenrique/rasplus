package com.client.ws.rasplus.exception.handler

import com.client.ws.rasplus.dto.ExceptionBody
import com.client.ws.rasplus.exception.NotFoundException
import com.client.ws.rasplus.utils.TranslatorCompomnent
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ExceptionHandler(private val translator: TranslatorCompomnent) : ResponseEntityExceptionHandler() {

    @ExceptionHandler(NotFoundException::class)
    fun notFoundException(e: NotFoundException, webRequest: WebRequest): ResponseEntity<Any>? {
        val message: String = translator.translate(e.message?:"")
        return handleExceptionInternal(
            e,
            ExceptionBody(
                message,
                HttpStatus.NOT_FOUND,
                e.message),
            HttpHeaders(),
            HttpStatus.NOT_FOUND,
            webRequest
        )
    }
}