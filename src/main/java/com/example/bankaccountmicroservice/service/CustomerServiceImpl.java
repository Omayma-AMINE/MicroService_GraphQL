package com.example.bankaccountmicroservice.service;

import com.example.bankaccountmicroservice.dto.CustomerDTO;
import com.example.bankaccountmicroservice.entities.Customer;
import com.example.bankaccountmicroservice.mappers.CustomerMapper;
import com.example.bankaccountmicroservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository ;
    @Autowired
    CustomerMapper customerMapper;
    @Override
    public List<CustomerDTO> getAllCustomers() {
       List<Customer> customerList = customerRepository.findAll();
       List<CustomerDTO> customerDTOList = new ArrayList<>();
       for (Customer customer : customerList){
           customerDTOList.add(customerMapper.fromCustomer(customer));
       }
       return customerDTOList;
    }
}
