package com.example.bank.ports.incoming;

import java.math.BigDecimal;

public interface CheckUseCase {

    BigDecimal check(Long id);
}