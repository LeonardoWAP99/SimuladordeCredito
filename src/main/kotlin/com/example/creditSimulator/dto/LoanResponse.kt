package com.example.creditSimulator.dto

import java.math.BigDecimal

data class LoanResponse(
    val totalLoanAmount: BigDecimal,
    val monthlyPaymentAmount: BigDecimal,
    val totalInterestAmount: BigDecimal
)
