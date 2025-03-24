package com.example.creditSimulator.dto

import java.math.BigDecimal

data class LoanResponse(
    val loanAmount: BigDecimal,
    val monthlyPayments: BigDecimal,
    val totalInterestRate: BigDecimal,
)
