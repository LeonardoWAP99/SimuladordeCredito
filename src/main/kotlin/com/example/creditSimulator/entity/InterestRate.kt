package domain.entity


class InterestRate {
    fun calculateTax(age: Int): Double {
        return when {
            age <= 25 -> 0.05
            age in 26..40 -> 0.03
            age in 41..60 -> 0.02
            else -> 0.04
        }
    }
}
