package com.trungnguyen.customer.controller;

import com.trungnguyen.customer.entity.Customer;
import com.trungnguyen.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getListCustomer() {
        return ResponseEntity.ok(customerService.getListCustomer());
    }

}
