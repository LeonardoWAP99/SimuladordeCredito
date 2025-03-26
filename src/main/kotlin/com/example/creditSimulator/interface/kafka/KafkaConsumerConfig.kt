package com.example.creditSimulator.`interface`.kafka

import com.example.creditSimulator.`interface`.model.LoanSimulationNotification
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConsumerConfig(private val kafkaProperties: KafkaProperties) {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, LoanSimulationNotification> {
        val config = mapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9092", // Verifique se o Kafka está rodando
            ConsumerConfig.GROUP_ID_CONFIG to "email-consumer-group",
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to JsonDeserializer::class.java,
        )

        val jsonDeserializer = JsonDeserializer(LoanSimulationNotification::class.java).apply {
            addTrustedPackages("*") // Adiciona pacotes confiáveis
            setRemoveTypeHeaders(false) // Não remove o cabeçalho de tipo
        }

        return DefaultKafkaConsumerFactory(config, StringDeserializer(), jsonDeserializer)
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, LoanSimulationNotification> {
        val kafkaListenerContainerFactory: ConcurrentKafkaListenerContainerFactory<String, LoanSimulationNotification> =
            ConcurrentKafkaListenerContainerFactory()

        return kafkaListenerContainerFactory.apply { consumerFactory = consumerFactory() }
    }
}
