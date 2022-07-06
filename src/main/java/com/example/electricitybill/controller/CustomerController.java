package com.example.electricitybill.controller;

import com.example.electricitybill.entity.Customer;
import com.example.electricitybill.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return service.saveCustomer(customer);
    }
    @PostMapping("/addCustomers")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers){
        return service.saveCustomers(customers);
    }
    @GetMapping("/Customers")
    public List<Customer> findAllCustomers(){
        return service.getCustomers();
    }
    @GetMapping("/CustomerById/{id}")
    public Customer findAllCustomers(@PathVariable int id){
        return service.getCustomerById(id);
    }
    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer){
        return service.updateCustomer(customer);
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id){
        return service.deleteCustomer(id);
    }



}
