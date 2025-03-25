package com.example.creditSimulator.dto

import java.math.BigDecimal
import java.time.LocalDate

data class LoanRequest(
    val loanRequestedAmount: BigDecimal,
    val loanTermInMonths: Int,
    val clientBirthDate: LocalDate
)
