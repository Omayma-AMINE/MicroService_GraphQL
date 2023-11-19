package com.example.bankaccountmicroservice.web;

import com.example.bankaccountmicroservice.dto.BankAccountRequestDTO;
import com.example.bankaccountmicroservice.dto.BankAccountResponseDTO;
import com.example.bankaccountmicroservice.entities.BankAccount;
import com.example.bankaccountmicroservice.mappers.BankAccountMapper;
import com.example.bankaccountmicroservice.repositories.BankAccountRepository;
import com.example.bankaccountmicroservice.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankAccountRestController {
    private BankAccountRepository bankAccountRepository;
    private BankAccountService bankAccountService;
    private BankAccountMapper bankAccountMapper;
    public BankAccountRestController(BankAccountRepository bankAccountRepository, BankAccountService bankAccountService, BankAccountMapper bankAccountMapper){
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountService = bankAccountService;
        this.bankAccountMapper = bankAccountMapper;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> bankAccounts(){
        return bankAccountService.getAllAccounts();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO bankAccount(@PathVariable String id){
        return bankAccountService.findBankAccount(id);
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
        return bankAccountService.addAccount(requestDTO);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO update(@PathVariable String id , @RequestBody BankAccountRequestDTO bankAccount){
        return bankAccountService.modifyAccount(id, bankAccount);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteBankAccount(@PathVariable String id){

        bankAccountService.deleteAccount(id);
    }



}
