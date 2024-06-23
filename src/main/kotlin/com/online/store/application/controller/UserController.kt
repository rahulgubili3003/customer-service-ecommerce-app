package com.online.store.application.controller

import com.online.store.application.dto.request.UserCreateRequest
import com.online.store.application.dto.response.OkResponse
import com.online.store.application.service.UserCreateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class UserController(private val service: UserCreateService) {

    @PostMapping("/add-customer")
    fun addCustomers(@RequestBody userCreateRequest: UserCreateRequest): ResponseEntity<OkResponse> {
        val response = service.createUser(userCreateRequest)
        return ResponseEntity.ok(OkResponse(data = response))
    }

    @PostMapping
    fun login(@RequestBody userCreateRequest: UserCreateRequest): ResponseEntity<OkResponse> {
        return ResponseEntity.ok(OkResponse())
    }
}