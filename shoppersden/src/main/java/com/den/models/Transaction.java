package com.den.models;

import lombok.Data;

@Data

public class Transaction {
    private int transId;
    private String transDate;
    private int pid; //Foreign Key references product(pid)
    private int price;
    private int qty;
    private int uid; //Foreign Key references user(uid)
}
