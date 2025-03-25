package com.example.creditSimulator.application.model

import java.math.BigDecimal
import java.time.LocalDate

data class LoanRequest(
    val loanAmount: BigDecimal,
    val loanTermInMonths: Int,
    val clientBirthDate: LocalDate
)
