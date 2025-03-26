package com.example.creditSimulator.application.useCase

import com.example.creditSimulator.application.model.LoanCalculationResult
import com.example.creditSimulator.application.model.LoanRequest
import com.example.creditSimulator.domain.entities.Client
import com.example.creditSimulator.domain.entities.InterestRate
import com.example.creditSimulator.domain.entities.Loan
import org.springframework.stereotype.Service

@Service
class LoanCalculationUseCase {
    fun calculateLoan(loanRequestModel: LoanRequest): LoanCalculationResult {
        val client = Client(birthDate = loanRequestModel.clientBirthDate)

        val loanInterestRate = InterestRate(client.age)

        loanInterestRate.rate

        val loanResponse = Loan(
            interestRate = loanInterestRate.rate,
            loanRequestedAmount = loanRequestModel.loanAmount,
            loanTermInMonths = loanRequestModel.loanTermInMonths,
        )

        return loanResponse.calculateLoan()
    }
}
