package org.example.controller;

import org.example.model.dto.Customer;
import org.example.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customerInfo")

public class CustomerController {

    CustomerService customerService=new CustomerService();

    @GetMapping("all")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable String id){
        for (Customer customer: customerService.getAll()){
            if(customer.getCustomerId().equalsIgnoreCase(id)){
                return customer;
            }
        }
        return null;
    }

    @PutMapping

    @DeleteMapping("{id}")
    public String deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
        return "deleted";

    }




}
