package com.example.bankaccountmicroservice;

import com.example.bankaccountmicroservice.entities.BankAccount;
import com.example.bankaccountmicroservice.entities.Customer;
import com.example.bankaccountmicroservice.enums.AccountType;
import com.example.bankaccountmicroservice.repositories.BankAccountRepository;
import com.example.bankaccountmicroservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountMicroServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
        return  args -> {
            Stream.of("Amine","Omayma","Hamza","Ismail").forEach(c-> {
                Customer customer = Customer.builder()
                        .name(c).build();
                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(customer -> {
                for(int i = 0; i < 5 ; i++){
                    BankAccount account = BankAccount.builder()
                            .accountID(UUID.randomUUID().toString())
                            .balance((double) Math.round(Math.random()*95000))
                            .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                            .currency(Math.random() > 0.5 ? "MAD" : "EURO")
                            .createdDate(LocalDate.now())
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(account);
                }
            });
        };
    }

}
