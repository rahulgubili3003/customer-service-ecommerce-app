package com.online.store.application.util

import com.online.store.application.dto.request.UserCreateRequest
import com.online.store.application.entity.Address
import com.online.store.application.entity.Customers

object Mappers {

    fun mapUserDtoToEntity(userCreateRequest: UserCreateRequest): Customers {
        return Customers(
            customerId = RandomUtil.generateCustomerId(),
            firstName = userCreateRequest.firstName,
            lastName = userCreateRequest.lastName,
            email = userCreateRequest.email,
            password = userCreateRequest.password,
            address = Address(
                buildingNo = userCreateRequest.address.buildingNo,
                streetOne = userCreateRequest.address.streetOne,
                streetTwo = userCreateRequest.address.streetTwo,
                city = userCreateRequest.address.city,
                zipCode = userCreateRequest.address.zipCode
            )
        )
    }
}