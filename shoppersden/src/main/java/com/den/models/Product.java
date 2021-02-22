package com.den.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product extends Category{
    private LocalDate dom;
    private int pid; //Primary Key
    private String pname;
    private int price;
    private int qty;
    private int cid; //Foreign Key
}
