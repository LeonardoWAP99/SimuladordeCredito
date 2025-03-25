package com.example.creditSimulator.`interface`.model

import java.math.BigDecimal
import java.time.LocalDate

data class LoanRequestModel(
    val loanRequestedAmount: BigDecimal,
    val loanTermInMonths: Int,
    val clientBirthDate: LocalDate
)
