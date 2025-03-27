package com.example.creditSimulator.`interface`.kafka

import com.example.creditSimulator.`interface`.model.LoanSimulationNotification
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducerService(private val kafkaTemplate: KafkaTemplate<String, LoanSimulationNotification>) {

    fun sendMessage(topic: String, message: LoanSimulationNotification) {
        try {
            val future = kafkaTemplate.send(topic, message)
            future.get()
            println("Mensagem enviada com sucesso para o tópico $topic: $message")
        } catch (e: Exception) {
            println("Erro ao enviar mensagem para o tópico $topic: ${e.message}")
        }
    }
}
