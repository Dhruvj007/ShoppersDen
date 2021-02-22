package com.den.dao;

import com.den.helper.PostgresConnHelper;
import com.den.models.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DaoImpl implements Dao {

    private Connection conn;
    private PreparedStatement category_pre,admin_pre,customer_pre,product_pre,trans_pre;
    private Statement statement;
    private ResultSet resultSet;
    private ResourceBundle resourceBundle;
    private Admin admin;
    private Category category;
    private Customer customer;
    private Product product;
    private Transaction transaction;

    public DaoImpl(){
        conn= PostgresConnHelper.getConnection();
        if(conn!=null)
            System.out.println("Connection ready...");
        else
            System.out.println("Connection has issue...");
        resourceBundle=ResourceBundle.getBundle("db");
    }

    @Override
    public void addCategory(Category category) throws SQLException {
        String addCategory=resourceBundle.getString("addcategory");
        category_pre=conn.prepareStatement(addCategory);
        category_pre.setString(1,category.getCname());
        category_pre.setInt(2,category.getCid());
        category_pre.execute();
        conn.commit();
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        String addProduct=resourceBundle.getString("addproduct");
        product_pre= conn.prepareStatement("addproduct");
        product_pre.setString(1,product.getPname());
        product_pre.setInt(2,product.getPid());
        product_pre.setInt(3,product.getPrice());
        product_pre.setInt(4,product.getQty());
        product_pre.setDate(5,Date.valueOf(product.getDom()));
        product_pre.setInt(6,product.getCid());
        product_pre.execute();
        conn.commit();
        //Date.valueOf(((FoodItems) category).getDoe())
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        String addCustomer=resourceBundle.getString("addcustomer");
        customer_pre=conn.prepareStatement("addcustomer");
        customer_pre.setString(1,customer.getEmail());
        customer_pre.setString(2,customer.getName());
        customer_pre.setString(3,customer.getAddress());
        customer_pre.setString(4,customer.getPwd());
        customer_pre.setLong(5,customer.getPhoneNo());
        customer_pre.setInt(6,customer.getUserID());
        customer_pre.execute();
        conn.commit();
    }

    @Override
    public void addAdmin(Admin admin) throws SQLException {
        String addadmin=resourceBundle.getString("addadmin");
        admin_pre=conn.prepareStatement("addadmin");
        admin_pre.setString(1,admin.getAname());
        admin_pre.setString(2,admin.getApwd());
        admin_pre.setInt(3,admin.getAid());
        admin_pre.execute();
        conn.commit();
    }

    @Override
    public void addTrans(Transaction trans) throws SQLException {
        String addtransaction=resourceBundle.getString("addtrans");
        trans_pre=conn.prepareStatement("addtransaction");
        trans_pre.setInt(1,trans.getTransId());
        trans_pre.setString(2,trans.getTransDate());
        trans_pre.setInt(3,trans.getPrice());
        trans_pre.setInt(4,trans.getPid());
        trans_pre.setInt(5,trans.getUid());
        trans_pre.setInt(6,trans.getQty());
        trans_pre.execute();
        conn.commit();
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        conn=PostgresConnHelper.getConnection();
        List<Product> productList=new ArrayList<Product>();
        String query=resourceBundle.getString("selectproducts");
        statement=conn.createStatement();
        resultSet=statement.executeQuery(query);
        while(resultSet.next())
        {
            Product prod=new Product();
            prod.setPname(resultSet.getString(1));
            prod.setPid(resultSet.getInt(2));
            prod.setPrice(resultSet.getInt(3));
            prod.setQty(resultSet.getInt(4));
            //prod.setDom(LocalDate(resultSet.getDate(5)));
            prod.setCid(resultSet.getInt(6));
            productList.add(prod);
        }
        return productList;
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        conn=PostgresConnHelper.getConnection();
        List<Customer> customerList=new ArrayList<Customer>();
        String query=resourceBundle.getString("selectcustomer");
        statement=conn.createStatement();
        resultSet=statement.executeQuery(query);
        while(resultSet.next())
        {
            Customer cust=new Customer();
            cust.setEmail(resultSet.getString(1));
            cust.setName(resultSet.getString(2));
            cust.setAddress(resultSet.getString(3));
            cust.setPwd(resultSet.getString(4));
            cust.setPhoneNo(resultSet.getLong(5));
            cust.setUserID(resultSet.getInt(6));
            //prod.setDom(LocalDate(resultSet.getDate(5)));
            customerList.add(cust);
        }
        return customerList;
    }


    @Override
    public Category getCategoryByID(int cid) throws SQLException {
        conn=PostgresConnHelper.getConnection();
        List<Category> categoryList=new ArrayList<Category>();
        String query=resourceBundle.getString("getcategory");
        statement=conn.createStatement();
        resultSet=statement.executeQuery(query);
        Category cat=new Category();
        cat.setCid(resultSet.getInt(1));
        cat.setCname(resultSet.getString(2));
        return cat;
    }

    @Override
    public void deleteProduct(int pid) throws SQLException{
        conn=PostgresConnHelper.getConnection();
        PreparedStatement delete = conn.prepareStatement(resourceBundle.getString("deleteproduct"));
        delete.setInt(1, product.getPid());
        System.out.println(delete);
        delete.executeUpdate();
        conn.commit();
    }


}
