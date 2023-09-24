package com.example.bank.services;

import com.example.bank.domain.BankAccount;
import com.example.bank.ports.incoming.CheckUseCase;
import com.example.bank.ports.incoming.DepositUseCase;
import com.example.bank.ports.incoming.WithdrawUseCase;
import com.example.bank.ports.outgoing.CheckAccountPort;
import com.example.bank.ports.outgoing.LoadAccountPort;
import com.example.bank.ports.outgoing.SaveAccountPort;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class BankAccountService implements DepositUseCase, WithdrawUseCase, CheckUseCase {

    private LoadAccountPort loadAccountPort;
    private SaveAccountPort saveAccountPort;
    private CheckAccountPort checkAccountPort;

    public BankAccountService(LoadAccountPort loadAccountPort, SaveAccountPort saveAccountPort, CheckAccountPort checkAccountPort) {
        this.loadAccountPort = loadAccountPort;
        this.saveAccountPort = saveAccountPort;
        this.checkAccountPort = checkAccountPort;
    }

    @Override
    public void deposit(Long id, BigDecimal amount) {
        BankAccount account = loadAccountPort.load(id)
                .orElseThrow(NoSuchElementException::new);

        account.deposit(amount);

        saveAccountPort.save(account);
    }

    @Override
    public boolean withdraw(Long id, BigDecimal amount) {
        BankAccount account = loadAccountPort.load(id)
                .orElseThrow(NoSuchElementException::new);

        boolean hasWithdrawn = account.withdraw(amount);

        if(hasWithdrawn) {
            saveAccountPort.save(account);
        }
        return hasWithdrawn;
    }

    @Override
    public BigDecimal check(Long id) {
        BankAccount account = loadAccountPort.load(id)
                .orElseThrow(NoSuchElementException::new);
        return checkAccountPort.getBalance(account.getId());
    }
}
