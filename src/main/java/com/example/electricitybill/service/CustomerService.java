package com.example.electricitybill.service;

import com.example.electricitybill.entity.Customer;
import com.example.electricitybill.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

     public Customer saveCustomer(Customer customer){
         return repository.save(customer);
     }
     public List<Customer> saveCustomers(List<Customer> customers){
         return repository.saveAll(customers);
     }
     public List<Customer> getCustomers(){
         return repository.findAll();
     }
     public Customer getCustomerById(int id){
         return repository.findById(id);
     }
     public String deleteCustomer(int id){
         repository.deleteById(id);
         return  "customer Removed ||"+id;
     }
     public Customer updateCustomer(Customer customer){
         Customer existingCustomer=repository.findById(customer.getId());
         existingCustomer.setName((customer.getName()));
         existingCustomer.setPhone(customer.getPhone());
         existingCustomer.setAddress(customer.getAddress());
         return repository.save(existingCustomer);
     }
}
