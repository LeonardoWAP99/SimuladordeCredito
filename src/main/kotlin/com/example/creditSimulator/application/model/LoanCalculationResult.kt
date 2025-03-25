package com.example.creditSimulator.application.model

import java.math.BigDecimal

data class LoanCalculationResult(
    val totalLoanAmount: BigDecimal,
    val monthlyPaymentAmount: BigDecimal,
    val totalInterestAmount: BigDecimal
)
