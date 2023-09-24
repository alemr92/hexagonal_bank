package com.example.bank.domain;


import java.math.BigDecimal;

// Its main responsibility is to model the business rules.
// It also verifies that the objects are always in a valid state
// The domain model should have no dependency on any specific technology.
// That’s the reason why you’ll find no Spring annotations here.
public class BankAccount {
    private Long id;

    private BigDecimal balance;

    public BankAccount(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public boolean withdraw(BigDecimal amount) {
        if(balance.compareTo(amount) < 0) {
            return false;
        }

        balance = balance.subtract(amount);
        return true;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public BigDecimal checkAmount() {
        return balance;
    }

    public Long getId() {
        return id;
    }
}
