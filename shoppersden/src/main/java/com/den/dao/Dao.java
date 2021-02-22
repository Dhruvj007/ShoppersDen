package com.den.dao;

import com.den.models.*;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    void addCategory(Category category) throws SQLException;
    void addProduct(Product product) throws SQLException;
    void addCustomer(Customer customer) throws SQLException;
    void addAdmin(Admin admin) throws SQLException;
    void addTrans(Transaction trans) throws SQLException;

    List<Product> getAllProducts() throws SQLException;
    List<Customer> getAllCustomers() throws SQLException;
    Category getCategoryByID(int cid) throws SQLException;
    void deleteProduct(int pid) throws SQLException;

}
