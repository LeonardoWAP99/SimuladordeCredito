package com.example.creditSimulator.controller


import com.example.creditSimulator.dto.LoanRequest
import com.example.creditSimulator.dto.LoanResponse
import com.example.creditSimulator.service.LoanService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/loan")
class LoanController(@Autowired val loanService: LoanService) {

    @PostMapping("/calculate")
    fun calculateLoan(@RequestBody loanRequest: LoanRequest): LoanResponse {
        return loanService.calculateLoan(loanRequest)
    }

    @GetMapping("/hello")
    fun hello(): String{
        return "hello, client"
    }
}