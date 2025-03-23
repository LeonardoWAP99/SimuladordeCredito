package com.example.creditSimulator.entity

import java.time.Clock
import java.time.LocalDate
import java.time.Period

class Client(val birthDate: LocalDate, private val clock: Clock = Clock.systemDefaultZone()) {
    fun getAge(): Int {
        val currentDate = LocalDate.now(clock)
        return Period.between(this.birthDate, currentDate).years
    }
}