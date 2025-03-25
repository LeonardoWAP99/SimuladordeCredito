package com.example.creditSimulator.`interface`.model

import java.math.BigDecimal

data class LoanSimulationNotification(
    val loanRequestAmount: BigDecimal,
    val loanTermInMonths: Int,
    val totalLoanAmount: BigDecimal,
    val monthlyPaymentAmount: BigDecimal,
    val totalInterestAmount: BigDecimal
)
