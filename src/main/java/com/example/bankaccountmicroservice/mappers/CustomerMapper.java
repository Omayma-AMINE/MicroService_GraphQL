package com.example.bankaccountmicroservice.mappers;

import com.example.bankaccountmicroservice.dto.BankAccountRequestDTO;
import com.example.bankaccountmicroservice.dto.BankAccountResponseDTO;
import com.example.bankaccountmicroservice.dto.CustomerDTO;
import com.example.bankaccountmicroservice.entities.BankAccount;
import com.example.bankaccountmicroservice.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        return customerDTO;
    }
    public Customer fromCustomerDTO (CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return customer;
    }

}
