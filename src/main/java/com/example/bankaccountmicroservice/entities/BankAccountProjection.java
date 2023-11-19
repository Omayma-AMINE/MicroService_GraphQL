package com.example.bankaccountmicroservice.entities;

import com.example.bankaccountmicroservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "firstProjection")
public interface BankAccountProjection {
    public String getAccountID();
    public AccountType getType() ;
}
