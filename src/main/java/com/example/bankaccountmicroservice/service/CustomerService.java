package com.example.bankaccountmicroservice.service;

import com.example.bankaccountmicroservice.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
}
