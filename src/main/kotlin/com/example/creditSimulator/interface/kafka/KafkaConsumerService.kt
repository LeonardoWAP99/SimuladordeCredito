package com.example.creditSimulator.`interface`.kafka

import com.example.creditSimulator.`interface`.email.EmailService
import com.example.creditSimulator.`interface`.model.LoanSimulationNotification
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumerService(
    private val emailService: EmailService,
) {

    @KafkaListener(topics = ["loan-topic"], groupId = "email-consumer-group")
    fun listen(loanSimulationNotification: LoanSimulationNotification) {
        println("Mensagem recebida: $loanSimulationNotification")
        sendEmail(loanSimulationNotification)
    }

    private fun sendEmail(loanSimulationNotification: LoanSimulationNotification) {
        val subject = "Resultado da Simulação de Empréstimo"
        val body = """
            Olá!! Segue sua simulação de empréstimo que foi feita com a gente!
            
            - Valor solicitado: ${loanSimulationNotification.loanRequestAmount}
            - Prazo do empréstimo: ${loanSimulationNotification.loanTermInMonths} meses
            - Valor total do empréstimo: ${loanSimulationNotification.totalLoanAmount}
            - Pagamento mensal: ${loanSimulationNotification.monthlyPaymentAmount}
            - Juros totais: ${loanSimulationNotification.totalInterestAmount}

            Não perca esta chance e solicite agora mesmo sua linha de credito!
      
        """.trimIndent()

        emailService.sendEmail(loanSimulationNotification.clientEmail, subject, body)
    }
}
