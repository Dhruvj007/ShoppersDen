package com.den.models;

import lombok.Data;

@Data

public class Customer {
    protected String email;
    protected String name;
    protected String address;
    protected String pwd;
    protected long phoneNo;
    protected int userID; //Primary Key
}
