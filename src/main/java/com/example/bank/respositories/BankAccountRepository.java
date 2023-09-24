package com.example.bank.respositories;

import com.example.bank.domain.BankAccount;
import com.example.bank.ports.outgoing.CheckAccountPort;
import com.example.bank.ports.outgoing.LoadAccountPort;
import com.example.bank.ports.outgoing.SaveAccountPort;
import com.example.bank.respositories.interfaces.SpringDataBankAccountRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

// BankAccountRepository class that connects the outgoing ports with the SpringDataBankAccountRepository:
@Component
public class BankAccountRepository implements LoadAccountPort, SaveAccountPort, CheckAccountPort {

    private SpringDataBankAccountRepository repository;

    public BankAccountRepository(SpringDataBankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<BankAccount> load(Long id) {
        return repository.findById(id);
    }

    @Override
    public BigDecimal checkAmount(Long id) {
        return null;
    }

    @Override
    public void save(BankAccount bankAccount) {
        repository.save(bankAccount);
    }

    @Override
    public BigDecimal getBalance(Long id) {
        Optional<BankAccount> bankAccount =  repository.findById(id);
        if(bankAccount.isPresent()) {
            return repository.findById(id).get().checkAmount();
        }
        return null;
    }
}
