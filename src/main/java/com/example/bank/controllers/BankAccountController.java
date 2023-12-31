package com.example.bank.controllers;

import com.example.bank.ports.incoming.CheckUseCase;
import com.example.bank.ports.incoming.DepositUseCase;
import com.example.bank.ports.incoming.WithdrawUseCase;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

// To complete our application, we need to provide implementations for the defined ports. We call these adapters.
//For the incoming interactions, we’ll create a REST controller
// The controller uses the defined ports to make calls to the application core.
@RestController
@RequestMapping("/account")
public class BankAccountController {

    private final CheckUseCase checkUseCase;
    private final DepositUseCase depositUseCase;
    private final WithdrawUseCase withdrawUseCase;

    public BankAccountController(CheckUseCase checkUseCase, DepositUseCase depositUseCase, WithdrawUseCase withdrawUseCase) {
        this.checkUseCase = checkUseCase;
        this.depositUseCase = depositUseCase;
        this.withdrawUseCase = withdrawUseCase;
    }

    @GetMapping(value = "/{id}")
    BigDecimal check(@PathVariable final Long id) {
        return checkUseCase.check(id);
    }


    @PostMapping(value = "/{id}/deposit/{amount}")
    void deposit(@PathVariable final Long id, @PathVariable final BigDecimal amount) {
        depositUseCase.deposit(id, amount);
    }

    @PostMapping(value = "/{id}/withdraw/{amount}")
    void withdraw(@PathVariable final Long id, @PathVariable final BigDecimal amount) {
        withdrawUseCase.withdraw(id, amount);
    }
}
