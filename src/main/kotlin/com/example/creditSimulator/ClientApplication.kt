package com.example.creditSimulator


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ClientApplication

fun main(args: Array<String>) {
    runApplication<ClientApplication>(*args)  // Inicializa a aplicação Spring Boot
}