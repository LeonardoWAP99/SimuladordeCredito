package com.example.creditSimulator.interfaces.controllers
import com.example.creditSimulator.application.model.LoanRequest
import com.example.creditSimulator.application.useCase.LoanCalculationUseCase
import com.example.creditSimulator.interfaces.kafka.KafkaProducerService
import com.example.creditSimulator.interfaces.model.LoanRequestModel
import com.example.creditSimulator.interfaces.model.LoanResponseModel
import com.example.creditSimulator.interfaces.model.LoanSimulationNotification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/loan")
class LoanController(
    @Autowired val loanCalculationUseCase: LoanCalculationUseCase,
    private val kafkaProducerService: KafkaProducerService,
) {
    @PostMapping("/calculate")
    fun processLoan(@RequestBody loanRequestModel: LoanRequestModel): LoanResponseModel {
        val request = LoanRequest(
            loanAmount = loanRequestModel.loanRequestedAmount,
            loanTermInMonths = loanRequestModel.loanTermInMonths,
            clientBirthDate = loanRequestModel.clientBirthDate,
        )

        val loanCalculationResult = loanCalculationUseCase.calculateLoan(request)

        val message = LoanSimulationNotification(
            loanRequestAmount = loanRequestModel.loanRequestedAmount,
            loanTermInMonths = loanRequestModel.loanTermInMonths,
            totalLoanAmount = loanCalculationResult.totalLoanAmount,
            monthlyPaymentAmount = loanCalculationResult.monthlyPaymentAmount,
            totalInterestAmount = loanCalculationResult.totalInterestAmount,
            clientEmail = loanRequestModel.clientEmail,
        )

        kafkaProducerService.sendMessage("loan-topic", message)

        return LoanResponseModel(
            loanCalculationResult.totalLoanAmount,
            loanCalculationResult.monthlyPaymentAmount,
            loanCalculationResult.totalInterestAmount,
        )
    }
}
