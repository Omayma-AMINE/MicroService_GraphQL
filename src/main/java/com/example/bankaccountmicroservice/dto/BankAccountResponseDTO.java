package com.example.bankaccountmicroservice.dto;

import com.example.bankaccountmicroservice.entities.Customer;
import com.example.bankaccountmicroservice.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String accountID;
    private Double balance;
    private LocalDate createdDate;
    private String currency;
    private AccountType type;
    private Customer customer;
}
