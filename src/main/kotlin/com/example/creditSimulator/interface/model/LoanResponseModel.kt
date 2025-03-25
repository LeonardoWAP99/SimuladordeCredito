package com.example.creditSimulator.`interface`.model

import java.math.BigDecimal

data class LoanResponseModel(
    val totalLoanAmount: BigDecimal,
    val monthlyPaymentAmount: BigDecimal,
    val totalInterestAmount: BigDecimal
)
