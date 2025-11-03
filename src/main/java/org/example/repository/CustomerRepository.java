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
        int i = preparedStatement.executeUpdate();

        System.out.println(i);

    }
}
