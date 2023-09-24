package com.example.bank.ports.outgoing;

import java.math.BigDecimal;

// These are for our application to interact with the database.
// Once again, we’ll have one per use case.
public interface CheckAccountPort {

    BigDecimal getBalance(Long id);

}
