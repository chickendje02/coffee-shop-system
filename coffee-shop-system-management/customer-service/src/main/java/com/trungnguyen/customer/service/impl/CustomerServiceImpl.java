package com.trungnguyen.customer.service.impl;

import com.trungnguyen.customer.entity.Customer;
import com.trungnguyen.customer.repository.CustomerRepository;
import com.trungnguyen.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> getListCustomer() {
        return customerRepository.findAll();
    }
}
