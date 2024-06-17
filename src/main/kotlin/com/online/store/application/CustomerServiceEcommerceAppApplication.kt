package com.online.store.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.TimeZone

@SpringBootApplication
class CustomerServiceEcommerceAppApplication

fun main(args: Array<String>) {
	TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
	runApplication<CustomerServiceEcommerceAppApplication>(*args)
}
