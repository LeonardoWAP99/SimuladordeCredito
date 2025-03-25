package com.example.creditSimulator.domain.entities

import com.example.creditSimulator.application.model.LoanCalculationResult
import java.math.BigDecimal
import java.math.RoundingMode

class Loan(
    private val interestRate: BigDecimal,
    private val loanRequestedAmount: BigDecimal,
    private val loanTermInMonths: Int
) {
    fun calculateLoan(): LoanCalculationResult {

        // Convert annual interest rate to monthly interest rate
        //use scale 10 for greater accuracy in calculation
        val monthlyInterestRate = interestRate.divide(BigDecimal("12"), 10, RoundingMode.HALF_EVEN)

        // Calculates the total amount that will be multiplied by the monthly interest rate
        val numerator = loanRequestedAmount.multiply(monthlyInterestRate)


        // Calculates the value of (1 + monthly interest rate)^-n, where n is the number of months
        //use scale 10 for greater accuracy in calculation
        val discountFactor =
            BigDecimal.valueOf(Math.pow(BigDecimal.ONE.add(monthlyInterestRate).toDouble(), (-loanTermInMonths).toDouble()))
                .setScale(10, RoundingMode.HALF_EVEN)

        // Calculate the denominator of the monthly payment formula
        val denominator = BigDecimal.ONE.subtract(discountFactor)

        // Calculates monthly payment
        val monthlyPaymentAmount = numerator.divide(denominator, 10, RoundingMode.HALF_EVEN).round()

        // Calculates the total paid after all months
        val totalLoanAmount = BigDecimal(loanTermInMonths) * monthlyPaymentAmount

        // Calculates the total interest paid during the period
        val totalInterestAmount = totalLoanAmount - loanRequestedAmount

        return LoanCalculationResult(totalLoanAmount.round(), monthlyPaymentAmount, totalInterestAmount.round())
    }

    // BigDecimal to 2 decimal places, using the HALF_EVEN rounding method (bank rounding).
    fun BigDecimal.round(): BigDecimal {
        return this.setScale(2, RoundingMode.HALF_EVEN)
    }
}
