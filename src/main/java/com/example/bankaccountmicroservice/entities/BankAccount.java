package com.example.bankaccountmicroservice.entities;

import com.example.bankaccountmicroservice.enums.AccountType;
import com.sun.jdi.PrimitiveValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountID;
    private Double balance;
    private LocalDate createdDate;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;
}
