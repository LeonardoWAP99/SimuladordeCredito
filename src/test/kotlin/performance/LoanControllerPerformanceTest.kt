package performance

import com.example.creditSimulator.CreditSimulatorApplication
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import kotlin.system.measureTimeMillis

@SpringBootTest(classes = [CreditSimulatorApplication::class])
@AutoConfigureMockMvc
class LoanControllerPerformanceTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should perform loan calculation without performance issues`() {
        val requestBody = """{
    "loanRequestedAmount": 10000,
    "loanTermInMonths": 24,
    "clientBirthDate": "1993-03-23",
     "clientEmail": "email@example.com"
     }"""

        val timeTaken =
            measureTimeMillis {
                mockMvc.perform(
                    MockMvcRequestBuilders.post("/loan/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody),
                )
                    .andExpect(MockMvcResultMatchers.status().isOk)
            }

        println("Time taken for the request: $timeTaken ms")
        assert(timeTaken < 1000) // Espera que o tempo de resposta seja menor que 1 segundo
    }
}
