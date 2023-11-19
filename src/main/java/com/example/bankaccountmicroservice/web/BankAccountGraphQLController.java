package com.example.bankaccountmicroservice.web;

import com.example.bankaccountmicroservice.dto.BankAccountRequestDTO;
import com.example.bankaccountmicroservice.dto.BankAccountResponseDTO;
import com.example.bankaccountmicroservice.dto.CustomerDTO;
import com.example.bankaccountmicroservice.entities.BankAccount;
import com.example.bankaccountmicroservice.enums.AccountType;
import com.example.bankaccountmicroservice.repositories.BankAccountRepository;
import com.example.bankaccountmicroservice.service.BankAccountService;
import com.example.bankaccountmicroservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BankAccountGraphQLController {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private  BankAccountService bankAccountService;
    @Autowired
    private CustomerService customerService;

    @QueryMapping
    public List<BankAccountResponseDTO> accountsList (){
        return bankAccountService.getAllAccounts();
    }

    @QueryMapping
    public BankAccountResponseDTO accountById (@Argument String id){
        return bankAccountService.findBankAccount(id);
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO account){
        return bankAccountService.addAccount(account);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id , @Argument BankAccountRequestDTO bankAccount){
        return bankAccountService.modifyAccount(id, bankAccount);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id){

        try {
            bankAccountService.deleteAccount(id);
            return true ;
        } catch (Exception e){
            return false ;
        }

    }

    @QueryMapping
    public List<CustomerDTO> customerList(){
        return customerService.getAllCustomers();
    }
    //record BankAccountDTO(Double balance, String currency, String type){    }

}
