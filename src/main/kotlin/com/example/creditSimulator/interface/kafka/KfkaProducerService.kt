package com.example.creditSimulator.`interface`.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducerService(private val kafkaTemplate: KafkaTemplate<String, String>) {

    fun sendMessage(topic: String, message: String) {
        try {
            val future = kafkaTemplate.send(topic, message)
            future.get()  // Espera o resultado do envio e lança exceção se houver erro
            println("Mensagem enviada com sucesso para o tópico $topic: $message")

        } catch (e: Exception) {
            println("Erro ao enviar mensagem para o tópico $topic: ${e.message}")
        }
    }
}
