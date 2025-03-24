package com.example.creditSimulator.service

import com.example.creditSimulator.dto.LoanRequest
import com.example.creditSimulator.dto.LoanResponse
import com.example.creditSimulator.entity.Client
import com.example.creditSimulator.entity.InterestRate
import com.example.creditSimulator.entity.Loan
import org.springframework.stereotype.Service

@Service
class LoanService {
    fun calculateLoan(loanRequest: LoanRequest): LoanResponse {
        val client = Client(birthDate = loanRequest.clientBirthDate)

        val loanInterestRate = InterestRate(client.age)

        loanInterestRate.rate

        val loan =
            Loan(
                interestRate = loanInterestRate.rate,
                loanAmount = loanRequest.loanRequestedAmount,
                paymentMonths = loanRequest.loanTermInMonths,
            )

        return loan.calculateCredit()
    }
}
