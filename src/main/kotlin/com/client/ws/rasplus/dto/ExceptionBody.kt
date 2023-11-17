package com.client.ws.rasplus.dto

import org.springframework.http.HttpStatus

data class ExceptionBody(
    val message: String?,
    val status: HttpStatus,
    val code: String?
)
