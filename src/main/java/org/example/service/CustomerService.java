package org.example.service;

import org.example.model.dto.Customer;
import org.example.repository.CustomerRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
   CustomerRepository customerRepository=new CustomerRepository();

    public List<Customer> getAll(){
        List<Customer> customers=new ArrayList<>();
        try {
            ResultSet resultSet= customerRepository.getAll();

            while (resultSet.next()){
                customers.add(new Customer(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)

                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    public void deleteCustomer(String id) {
        try {
            customerRepository.deleteCustomer(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addCustomer(Customer customer) {
        try {
            customerRepository.addCustomer(customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCustomer(String id, Customer customer) {
        try {
            customerRepository.updateCustomer(id,customer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
