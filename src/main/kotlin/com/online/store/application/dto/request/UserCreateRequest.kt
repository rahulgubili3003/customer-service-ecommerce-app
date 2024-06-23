package com.online.store.application.dto.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserCreateRequest(
    @field:Size(max = 50, min = 3)
    val firstName: String,
    @field:Size(max = 50, min = 3)
    val lastName: String,
    @field:Email
    val email: String,
    @field:NotNull
    val address: AddressRequest,
    @field:NotBlank
    var password: String,
    @field:NotBlank
    val confirmPassword: String
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class AddressRequest(
    @field:NotBlank
    val buildingNo: String,
    @field:NotBlank
    val streetOne: String,
    val streetTwo: String,
    @field:NotBlank
    val city: String,
    @field:Size(max = 6, min = 6)
    val zipCode: String
)
