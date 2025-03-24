package com.example.creditSimulator.entity

import java.time.Clock
import java.time.LocalDate
import java.time.Period

class Client(val birthDate: LocalDate) {
    val age: Int

    init {
        this.age = getAge()
    }

    fun getAge(clock: Clock = Clock.systemDefaultZone()): Int {
        val currentDate = LocalDate.now(clock)
        return Period.between(this.birthDate, currentDate).years
    }
}
