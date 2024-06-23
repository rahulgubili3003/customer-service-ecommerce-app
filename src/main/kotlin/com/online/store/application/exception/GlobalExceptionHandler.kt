package com.online.store.application.exception

import com.online.store.application.constants.ErrorConstants.ERR_001
import com.online.store.application.dto.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handlePasswordException(ex: PasswordNotMatchingException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            errorCode = ERR_001,
            errorMessage = "Passwords Not Matching",
            cause = ex.message?: "Confirm Password not matching with the entered password"
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }
}