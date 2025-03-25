package domain.entity

import com.example.creditSimulator.entity.Loan
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.RoundingMode

class LoanTest {
    @Test
    fun `when interest rate is 0,05 per year and loan is 10000,00 for 24 months then monthly payment should calculate correctly `() {
        val interestRate = BigDecimal(0.05)
        val totalLoanAmount = BigDecimal(10000)
        val paymentMonths = 24
        val loan = Loan(interestRate, totalLoanAmount, paymentMonths)
        val (totalPaid, monthlyPayment, totalInterest) = loan.calculateLoan()

        assertEquals(BigDecimal(438.71).setScale(2, RoundingMode.HALF_EVEN), monthlyPayment)
        assertEquals(BigDecimal(10529.04).setScale(2, RoundingMode.HALF_EVEN), totalPaid)
        assertEquals(BigDecimal(529.04).setScale(2, RoundingMode.HALF_EVEN), totalInterest)
    }

    @Test
    fun `when interest rate is 0,055 per year and loan is 10000,00 for 24 months then monthly payment should calculate correctly`() {
        val interestRate = BigDecimal(0.055)
        val totalLoanAmount = BigDecimal(10000.00)
        val paymentMonths = 24
        val loan = Loan(interestRate, totalLoanAmount, paymentMonths)
        val (totalPaid, monthlyPayment, totalInterest) = loan.calculateLoan()

        assertEquals(BigDecimal(440.96).setScale(2, RoundingMode.HALF_EVEN), monthlyPayment)
        assertEquals(BigDecimal(10583.04).setScale(2, RoundingMode.HALF_EVEN), totalPaid)
        assertEquals(BigDecimal(583.04).setScale(2, RoundingMode.HALF_EVEN), totalInterest)
    }

    @Test
    fun `when interest rate is 0,03 per year and loan is 10000,00 for 24 months then monthly payment should calculate correctly`() {
        val interestRate = BigDecimal(0.03)
        val totalLoanAmount = BigDecimal(10000)
        val paymentMonths = 24
        val loan = Loan(interestRate, totalLoanAmount, paymentMonths)
        val (totalPaid, monthlyPayment, totalInterest) = loan.calculateLoan()

        assertEquals(BigDecimal(429.81).setScale(2, RoundingMode.HALF_EVEN), monthlyPayment)
        assertEquals(BigDecimal(10315.44).setScale(2, RoundingMode.HALF_EVEN), totalPaid)
        assertEquals(BigDecimal(315.44).setScale(2, RoundingMode.HALF_EVEN), totalInterest)
    }
}
