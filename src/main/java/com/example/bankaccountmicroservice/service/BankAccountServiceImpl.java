package com.example.bankaccountmicroservice.service;

import com.example.bankaccountmicroservice.dto.BankAccountRequestDTO;
import com.example.bankaccountmicroservice.dto.BankAccountResponseDTO;
import com.example.bankaccountmicroservice.entities.BankAccount;
import com.example.bankaccountmicroservice.enums.AccountType;
import com.example.bankaccountmicroservice.mappers.BankAccountMapper;
import com.example.bankaccountmicroservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private BankAccountMapper bankAccountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount account = BankAccount.builder()
            .accountID(UUID.randomUUID().toString())
            .balance(bankAccountDTO.getBalance())
            .type(bankAccountDTO.getType())
            .currency(bankAccountDTO.getCurrency())
            .createdDate(LocalDate.now())
            .build();
        BankAccount savedAccount = bankAccountRepository.save(account);
        BankAccountResponseDTO bankAccountResponseDTO = bankAccountMapper.fromBankAccount(savedAccount);
        return bankAccountResponseDTO;
    }

    public BankAccountResponseDTO findBankAccount(String id ){
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found",id)));
        BankAccountResponseDTO bankAccountResponseDTO = bankAccountMapper.fromBankAccount(account);
        return bankAccountResponseDTO;
    }

    @Override
    public List<BankAccountResponseDTO> getAllAccounts() {
        List<BankAccount> accounts= bankAccountRepository.findAll();

        List<BankAccountResponseDTO> accountResponseDTOList = new ArrayList<>();
        for (BankAccount account: accounts) {
            accountResponseDTOList.add(bankAccountMapper.fromBankAccount(account));
        }
        return accountResponseDTOList;
    }

    @Override
    public BankAccountResponseDTO modifyAccount(String id, BankAccountRequestDTO requestDTO) {
        BankAccount account =  bankAccountRepository.findById(id).orElseThrow();

        if ( requestDTO.getBalance() != null ) account.setBalance(requestDTO.getBalance());
        if ( requestDTO.getType() != null ) account.setType(requestDTO.getType());
        if ( requestDTO.getCurrency() != null ) account.setCurrency(requestDTO.getCurrency());
        if ( requestDTO.getCreatedDate() != null ) account.setCreatedDate(requestDTO.getCreatedDate());

        BankAccount savedAccount = bankAccountRepository.save(account);

        return bankAccountMapper.fromBankAccount(savedAccount);
    }

    @Override
    public void deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
}
