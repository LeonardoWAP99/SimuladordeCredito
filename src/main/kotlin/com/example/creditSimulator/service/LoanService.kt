package com.example.creditSimulator.service

import com.example.creditSimulator.dto.LoanRequest
import com.example.creditSimulator.dto.LoanResponse
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class LoanService {

    fun calculateLoan(loanRequest: LoanRequest): LoanResponse {
        val interestRate = BigDecimal("5") // Exemplo de taxa de juros anual
        val loanAmount = loanRequest.loanRequestAmount
        val loanTime = loanRequest.loanTime

        // Calculando a taxa de juros mensal
        val monthlyInterestRate = interestRate.divide(BigDecimal("100"), 10, RoundingMode.HALF_EVEN)
            .divide(BigDecimal("12"), 10, RoundingMode.HALF_EVEN)

        // Cálculo do pagamento mensal
        val numerator = loanAmount.multiply(monthlyInterestRate)
        val onePlusMonthlyRate = BigDecimal.ONE.add(monthlyInterestRate)
        val discountFactor = BigDecimal.valueOf(Math.pow(onePlusMonthlyRate.toDouble(), (-loanTime).toDouble()))
            .setScale(10, RoundingMode.HALF_EVEN)
        val denominator = BigDecimal.ONE.subtract(discountFactor)
        val monthlyPayment = numerator.divide(denominator, 10, RoundingMode.HALF_EVEN).round()

        // Cálculo do total pago
        val totalPaid = BigDecimal(loanTime) * monthlyPayment

        // Cálculo dos juros totais
        val totalInterest = totalPaid - loanAmount

        return LoanResponse(loanAmount, monthlyPayment, totalInterest)
    }

    private fun BigDecimal.round(): BigDecimal {
        return this.setScale(2, RoundingMode.HALF_EVEN)
    }
}
