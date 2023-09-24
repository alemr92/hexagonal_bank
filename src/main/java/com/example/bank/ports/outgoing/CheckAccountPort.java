package com.example.bank.ports.outgoing;

import java.math.BigDecimal;

public interface CheckAccountPort {

    BigDecimal getBalance(Long id);

}
