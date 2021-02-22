package com.den.utility;

import com.den.dao.Dao;
import com.den.dao.DaoImpl;
import com.den.models.Admin;
import com.den.models.Category;
import com.den.models.Customer;
import com.den.models.Product;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class App {
    public static void main(String args[]) {
        Dao dao = new DaoImpl();
        Product product=new Product();
        product=createProduct();
        System.out.println(product);
        Customer customer=new Customer();
        customer=createCustomer();
        System.out.print(customer);
        Admin admin=new Admin();
        admin=createAdmin();
        System.out.println(admin);
        }

        public static Product createProduct () {
            Product product = new Product();
            product.setPname("Polo");
            product.setPid(new Random().nextInt(1000000));
            product.setPrice(1000);
            product.setQty(12);
            product.setDom(LocalDate.now());
            product.setCid(100);
            return product;
        }
        public static Customer createCustomer () {
            Customer customer = new Customer();
            customer.setEmail("abc@xyz.com");
            customer.setName("abc");
            customer.setAddress("Mumbai");
            customer.setPwd("12344");
            customer.setPhoneNo(38929739);
            customer.setUserID(345);
            return customer;
        }
        public static Admin createAdmin () {
            Admin admin = new Admin();
            admin.setAname("Anil");
            admin.setApwd("anilrocks");
            admin.setAid(989);
            return admin;
        }

}