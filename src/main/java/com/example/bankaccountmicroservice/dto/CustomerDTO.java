package com.example.bankaccountmicroservice.dto;

import com.example.bankaccountmicroservice.entities.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private Long customerId;
    private String name;
    private List<BankAccount> accounts;

}

