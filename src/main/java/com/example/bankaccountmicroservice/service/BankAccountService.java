package com.example.bankaccountmicroservice.service;

import com.example.bankaccountmicroservice.dto.BankAccountRequestDTO;
import com.example.bankaccountmicroservice.dto.BankAccountResponseDTO;

import java.util.List;

public interface BankAccountService {

    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    BankAccountResponseDTO findBankAccount(String id);
    List<BankAccountResponseDTO> getAllAccounts ();
    BankAccountResponseDTO modifyAccount(String id , BankAccountRequestDTO requestDTO);
    void deleteAccount(String id );
}
