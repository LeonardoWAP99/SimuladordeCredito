package com.example.creditSimulator.`interface`.controllers

import com.example.creditSimulator.`interface`.model.LoanRequestModel
import com.example.creditSimulator.`interface`.model.LoanResponseModel
import com.example.creditSimulator.application.useCase.LoanCalculationUseCase
import com.example.creditSimulator.application.model.LoanRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/loan")
class LoanController(
    @Autowired val loanCalculationUseCase: LoanCalculationUseCase,
) {
    @PostMapping("/calculate")
    fun calculateLoan(@RequestBody loanRequestModel: LoanRequestModel): LoanResponseModel {
        val request = LoanRequest(loanAmount = loanRequestModel.loanRequestedAmount,
                                  loanTermInMonths = loanRequestModel.loanTermInMonths,
                                  clientBirthDate = loanRequestModel.clientBirthDate)
        val loanCalculationResult = loanCalculationUseCase.calculateLoan(request)
        return LoanResponseModel(loanCalculationResult.totalLoanAmount,
                                loanCalculationResult.monthlyPaymentAmount,
                                loanCalculationResult.totalInterestAmount)
    }
}
