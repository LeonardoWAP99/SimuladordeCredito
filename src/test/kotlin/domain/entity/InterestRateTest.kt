package domain.entity

import com.example.creditSimulator.entity.InterestRate
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class InterestRateTest {
    private val interestRate = InterestRate()

    @Test
    fun `should return 0_05 for age between 0 and 25`() {
        assertEquals(0.05, interestRate.calculateTax(0))
        assertEquals(0.05, interestRate.calculateTax(15))
        assertEquals(0.05, interestRate.calculateTax(25))
    }

    @Test
    fun `should return 0_03 for age between 26 and 40`() {
        assertEquals(0.03, interestRate.calculateTax(26))
        assertEquals(0.03, interestRate.calculateTax(35))
        assertEquals(0.03, interestRate.calculateTax(40))
    }

    @Test
    fun `should return 0_02 for age between 41 and 60`() {
        assertEquals(0.02, interestRate.calculateTax(50))
        assertEquals(0.02, interestRate.calculateTax(41))
        assertEquals(0.02, interestRate.calculateTax(60))
    }

    @Test
    fun `should return 0_04 for age between 60+`() {
        assertEquals(0.04, interestRate.calculateTax(61))
        assertEquals(0.04, interestRate.calculateTax(70))
        assertEquals(0.04, interestRate.calculateTax(80))
        assertEquals(0.04, interestRate.calculateTax(90))
        assertEquals(0.04, interestRate.calculateTax(100))
    }
}