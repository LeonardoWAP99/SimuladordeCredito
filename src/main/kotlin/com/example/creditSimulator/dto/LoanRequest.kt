package com.example.creditSimulator.dto

import java.math.BigDecimal
import java.time.LocalDate

data class LoanRequest(
    val loanRequestAmount: BigDecimal,
    val loanTime: Int,
    val clientBirthDate: LocalDate,
)
