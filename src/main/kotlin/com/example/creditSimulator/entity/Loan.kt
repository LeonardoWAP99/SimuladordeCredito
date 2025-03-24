package com.example.creditSimulator.entity

import java.math.BigDecimal
import java.math.RoundingMode

import com.example.creditSimulator.dto.LoanResponse

class Loan(
    private val interestRate: BigDecimal,
    private val loanAmount: BigDecimal,
    private val  paymentMonths: Int
    ) {
         fun calculateCredit(): LoanResponse{
             // Convert annual interest rate to monthly interest rate
             val monthlyInterestRate = interestRate.divide(BigDecimal( "12"), 10, RoundingMode.HALF_EVEN)

             // Calculates the total amount that will be multiplied by the monthly interest rate
             val numerator = loanAmount.multiply(monthlyInterestRate)

             // Calculates (1 + monthly interest rate)
             val onePlusMonthlyRate = BigDecimal.ONE.add(monthlyInterestRate)

             // Calculates the value of (1 + monthly interest rate)^-n, where n is the number of months
             val discountFactor = BigDecimal.valueOf(Math.pow(onePlusMonthlyRate.toDouble(), (-paymentMonths).toDouble()))
                 .setScale(10, RoundingMode.HALF_EVEN)


             // Calculate the denominator of the monthly payment formula
             val denominator = BigDecimal.ONE.subtract(discountFactor)

             // Calculates monthly payment
             val monthlyPayment = numerator.divide(denominator, 10, RoundingMode.HALF_EVEN).round()

             //Calculates the total paid after all months
             val totalPaid = BigDecimal(paymentMonths) * monthlyPayment
             println(totalPaid)

             // Calculates the total interest paid during the period
             val totalInterest = totalPaid - loanAmount

             // Retorna o pagamento mensal, o total pago e o total de juros pagos
             return LoanResponse(totalPaid.round(), monthlyPayment,  totalInterest.round())
         }

    // BigDecimal to 2 decimal places, using the HALF_EVEN rounding method (bank rounding).
    fun BigDecimal.round(): BigDecimal {
        return this.setScale(2, RoundingMode.HALF_EVEN)
    }
}