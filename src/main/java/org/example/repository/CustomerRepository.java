package org.example.repository;

import org.example.model.dto.Customer;

import java.sql.*;
import java.util.List;

public class CustomerRepository {
    public ResultSet getAll() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation_db","root","1234");
        PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM customers");
        return preparedStatement.executeQuery();
    }

    public void deleteCustomer(String id) throws SQLException {
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation_db","root","1234");
        PreparedStatement preparedStatement= connection.prepareStatement("DELETE FROM customers WHERE customer_id=?");
        preparedStatement.setObject(1,id);
        preparedStatement.executeUpdate();
    }

    public void addCustomer(Customer customer) throws SQLException {
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation_db","root","1234");
        PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO customers VALUES(?,?,?,?)");
        preparedStatement.setObject(1,customer.getCustomerId());
        preparedStatement.setObject(2,customer.getName());
        preparedStatement.setObject(3,customer.getPhone());
        preparedStatement.setObject(4,customer.getCity());

        preparedStatement.executeUpdate();

    }
}
