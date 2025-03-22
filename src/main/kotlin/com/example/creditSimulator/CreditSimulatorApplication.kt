package com.example.creditSimulator

import domain.entity.Client
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate

@SpringBootApplication
class CreditSimulatorApplication

fun main(args: Array<String>) {
	runApplication<CreditSimulatorApplication>(*args)
	val client = Client(birthDate = LocalDate.of(1999,5,10))
	println("idade do cliente ${client.getAge()} anos")

}
