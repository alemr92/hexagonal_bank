package com.example.bank.ports.incoming;

import java.math.BigDecimal;

// These are used by external components to call our application.
// In this case, we’ll have one per use case
public interface CheckUseCase {

    BigDecimal check(Long id);
}