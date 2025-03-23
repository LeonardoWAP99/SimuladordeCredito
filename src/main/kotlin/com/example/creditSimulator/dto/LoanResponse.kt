package com.example.creditSimulator.dto

import com.example.creditSimulator.entity.InterestRate
import java.math.BigDecimal
import java.time.LocalDate

data class LoanResponse (
    val loanAmount : BigDecimal,
    val monthlyPayments : BigDecimal,
    val totalInterestRate: BigDecimal
)