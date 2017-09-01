package com.neeson.controller;

import com.neeson.domain.Customer;
import com.neeson.repository.CustomerRepository;
import com.neeson.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by daile on 2017/9/1.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/all")
    public List<Customer> loadCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable(value = "id") Long id) {
        return customerRepository.findOne(id);
    }

    @PostMapping(value = "/add")
    public String addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return "success";
    }


}
