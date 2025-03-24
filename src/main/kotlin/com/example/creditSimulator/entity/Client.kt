package com.example.creditSimulator.entity

import java.time.Clock
import java.time.LocalDate
import java.time.Period

class Client(val birthDate: LocalDate,
             clock: Clock = Clock.systemDefaultZone()) {
    val age: Int

    init {
        val currentDate = LocalDate.now(clock)
        this.age = calculateAge(currentDate)
    }

     private fun calculateAge(currentDate: LocalDate): Int {

        return Period.between(this.birthDate, currentDate).years
    }
}
