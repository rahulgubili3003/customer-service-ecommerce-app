package com.online.store.application.dto.response

data class ErrorResponse(
    val errorCode: String,
    val errorMessage: String,
    val cause: String
)
