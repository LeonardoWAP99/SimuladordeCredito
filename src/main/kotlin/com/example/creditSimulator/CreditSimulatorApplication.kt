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
}
