package com.online.store.application.repository

import com.online.store.application.entity.Customers
import org.springframework.data.jpa.repository.JpaRepository

interface CustomersRepository: JpaRepository<Customers, Long> {
}