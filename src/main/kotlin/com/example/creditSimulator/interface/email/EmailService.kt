package com.example.creditSimulator.`interface`.email

import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

@Service
class EmailService(
    private val javaMailSender: JavaMailSender
) {

    // Método para enviar o e-mail com o conteúdo necessário
    fun sendEmail(recipient: String, subject: String, body: String) {
        try {
            val mimeMessage = javaMailSender.createMimeMessage()
            val helper = MimeMessageHelper(mimeMessage, true)
            helper.setTo(recipient)
            helper.setSubject(subject)
            helper.setText(body)

            javaMailSender.send(mimeMessage)
            println("E-mail enviado com sucesso!")
        } catch (e: Exception) {
            println("Erro ao enviar e-mail: ${e.message}")
        }
    }
}