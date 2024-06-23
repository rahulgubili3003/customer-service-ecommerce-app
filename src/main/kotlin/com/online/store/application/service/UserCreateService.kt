package com.online.store.application.service

import com.online.store.application.dto.request.UserCreateRequest
import com.online.store.application.exception.PasswordNotMatchingException
import com.online.store.application.repository.CustomersRepository
import com.online.store.application.util.Mappers
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class UserCreateService(private val customersRepository: CustomersRepository, private val bCryptPasswordEncoder: BCryptPasswordEncoder) {

    fun createUser(@RequestBody userCreateRequest: UserCreateRequest): Long? {
        val rawPassword = userCreateRequest.password
        if (rawPassword != userCreateRequest.confirmPassword) {
            throw PasswordNotMatchingException("Ensure that you enter password and the same confirm password")
        }
        val hashedPassword = bCryptPasswordEncoder.encode(rawPassword)
        userCreateRequest.password = hashedPassword
        val customerEntity = Mappers.mapUserDtoToEntity(userCreateRequest)
        val savedEntity = customersRepository.save(customerEntity)
        return savedEntity.id
    }
}