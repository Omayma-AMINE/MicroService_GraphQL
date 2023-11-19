package com.example.bankaccountmicroservice.mappers;

import com.example.bankaccountmicroservice.dto.BankAccountRequestDTO;
import com.example.bankaccountmicroservice.dto.BankAccountResponseDTO;
import com.example.bankaccountmicroservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
    public BankAccount fromBankAccountDTO(BankAccountRequestDTO bankAccountRequestDTO){
        BankAccount account = new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDTO,account);
        return account;

    }
}
