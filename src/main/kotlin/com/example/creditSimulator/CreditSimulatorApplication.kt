package com.example.creditSimulator

import com.example.creditSimulator.entity.InterestRate
import com.example.creditSimulator.entity.Client
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate

@SpringBootApplication
class CreditSimulatorApplication

fun main(args: Array<String>) {
	runApplication<CreditSimulatorApplication>(*args)
	val client = Client(birthDate = LocalDate.of(1999,5,10))
	println("idade do cliente ${client.getAge()} anos")

	val interestRate = InterestRate()

	val age1 = 20
	val age2 = 30
	val age3 = 50
	val age4 = 65

	println("Taxa de juros para idade $age1: ${interestRate.calculateTax(age1)}")
	println("Taxa de juros para idade $age2: ${interestRate.calculateTax(age2)}")
	println("Taxa de juros para idade $age3: ${interestRate.calculateTax(age3)}")
	println("Taxa de juros para idade $age4: ${interestRate.calculateTax(age4)}")

}
