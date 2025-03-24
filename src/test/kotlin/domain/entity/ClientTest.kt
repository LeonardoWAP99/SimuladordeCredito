package domain.entity

import com.example.creditSimulator.entity.Client
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.Clock
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

class ClientTest {
    @Test
    fun `test getAge() returns correct age`() {
        val birthDate = LocalDate.of(1999, 5, 10)

        val fixedClock = Clock.fixed(Instant.parse("2025-05-11T00:00:00Z"), ZoneId.of("UTC"))

        val client = Client(birthDate)

        val expectedAge = 26

        assertEquals(expectedAge, client.getAge(fixedClock), "A idade calculada está incorreta")
    }

    @Test
    fun `test getAge when birthday is yet to come this year`() {
        val birthDate = LocalDate.of(1999, 5, 10)

        val fixedClock = Clock.fixed(Instant.parse("2025-01-10T00:00:00Z"), ZoneId.of("UTC"))

        val client = Client(birthDate)

        val expectedAge = 25

        assertEquals(expectedAge, client.getAge(fixedClock), "A idade calculada está incorreta")
    }

    @Test
    fun `test getAge() when birthday is in a leap year and has occurred`() {
        val birthDate = LocalDate.of(2000, 2, 29)

        val fixedClock = Clock.fixed(Instant.parse("2024-03-01T00:00:00Z"), ZoneId.of("UTC"))

        val client = Client(birthDate)

        val expectedAge = 24 // Já fez 24 anos
        assertEquals(expectedAge, client.getAge(fixedClock), "A idade calculada está incorreta")
    }
}
