package domain.entity

import com.example.creditSimulator.entity.InterestRate
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal

class InterestRateTest {

    @Test
    fun `should return 0_05 for age between 0 and 25`() {
        val interestRateUnder25 = InterestRate(clientAge = 0)
        assertEquals(interestRateUnder25.rate.setScale(2), BigDecimal("0.05").setScale(2))

        val interestRate15 = InterestRate(clientAge = 15)
        assertEquals(interestRate15.rate.setScale(2), BigDecimal("0.05").setScale(2))

        val interestRate25 = InterestRate(clientAge = 25)
        assertEquals(interestRate25.rate.setScale(2), BigDecimal("0.05").setScale(2))
    }

    @Test
    fun `should return 0_03 for age between 26 and 40`() {
        val interestRate26 = InterestRate(clientAge = 26)
        assertEquals(interestRate26.rate.setScale(2), BigDecimal("0.03").setScale(2))

        val interestRate35 = InterestRate(clientAge = 35)
        assertEquals(interestRate35.rate.setScale(2), BigDecimal("0.03").setScale(2))

        val interestRate40 = InterestRate(clientAge = 40)
        assertEquals(interestRate40.rate.setScale(2), BigDecimal("0.03").setScale(2))
    }

    @Test
    fun `should return 0_02 for age between 41 and 60`() {
        val interestRate50 = InterestRate(clientAge = 50)
        assertEquals(interestRate50.rate.setScale(2), BigDecimal("0.02").setScale(2))

        val interestRate41 = InterestRate(clientAge = 41)
        assertEquals(interestRate41.rate.setScale(2), BigDecimal("0.02").setScale(2))

        val interestRate60 = InterestRate(clientAge = 60)
        assertEquals(interestRate60.rate.setScale(2), BigDecimal("0.02").setScale(2))
    }

    @Test
    fun `should return 0_04 for age between 60+`() {
        val interestRate61 = InterestRate(clientAge = 61)
        assertEquals(interestRate61.rate.setScale(2), BigDecimal("0.04").setScale(2))

        val interestRate70 = InterestRate(clientAge = 70)
        assertEquals(interestRate70.rate.setScale(2), BigDecimal("0.04").setScale(2))

        val interestRate80 = InterestRate(clientAge = 80)
        assertEquals(interestRate80.rate.setScale(2), BigDecimal("0.04").setScale(2))

        val interestRate90 = InterestRate(clientAge = 90)
        assertEquals(interestRate90.rate.setScale(2), BigDecimal("0.04").setScale(2))

        val interestRate100 = InterestRate(clientAge = 100)
        assertEquals(interestRate100.rate.setScale(2), BigDecimal("0.04").setScale(2))
    }
    }