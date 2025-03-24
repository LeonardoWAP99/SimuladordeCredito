package com.example.creditSimulator.entity

import java.math.BigDecimal
import java.math.RoundingMode


class InterestRate(clientAge: Int ){

    val rate : BigDecimal

    init {
        this.rate = getCorrectTax(clientAge)
    }

    private fun getCorrectTax(age: Int): BigDecimal {
        return when {
            age <= 25 ->BigDecimal( 0.05)
            age in 26..40 -> BigDecimal(0.03)
            age in 41..60 ->BigDecimal(0.02)
            else ->BigDecimal( 0.04)
        }.setScale(2, RoundingMode.HALF_EVEN)
    }
}
