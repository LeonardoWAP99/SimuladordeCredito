package integration

import com.example.creditSimulator.CreditSimulatorApplication
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*

@SpringBootTest(classes = [CreditSimulatorApplication::class])
@AutoConfigureMockMvc
@ActiveProfiles("test")
class LoanIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should calculate loan correctly`() {
        val requestBody =
            """
            {
                "loanRequestedAmount": 10000,
                "loanTermInMonths": 24,
                "clientBirthDate": "1999-05-10",
                "clientEmail": "email@example.com"
            }
            """.trimIndent()

        mockMvc.perform(
            post("/loan/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody),
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.totalLoanAmount").value(10529.04))
            .andExpect(jsonPath("$.monthlyPaymentAmount").value(438.71))
            .andExpect(jsonPath("$.totalInterestAmount").value(529.04))
    }
}
