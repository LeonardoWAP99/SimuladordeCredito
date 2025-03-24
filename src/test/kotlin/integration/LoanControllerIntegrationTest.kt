package integration

import com.example.creditSimulator.CreditSimulatorApplication
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles


import org.springframework.test.web.servlet.MockMvc

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.http.MediaType

@SpringBootTest(classes = [CreditSimulatorApplication::class])
@AutoConfigureMockMvc
@ActiveProfiles("test") // Usa um perfil de teste para configurações específicas
class LoanIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should calculate loan correctly`() {
        val requestBody = """
            {
                "loanRequestAmount": 10000,
                "loanTime": 24,
                "clientBirthDate": "1999-05-10"
            }
        """.trimIndent()

        mockMvc.perform(
            post("/loan/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.loanAmount").value( 10529.04 ))
    }
}