package com.den.connTest;

import com.den.models.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class prodTest {

    private Product p1,p2;


    @BeforeEach
    public void getInstance(){
    p1=new Product();
    p1.setPid(new Random().nextInt(10000));
    p2=new Product();
    p2.setPid(new Random().nextInt(10000));
    }

    @Test
    @DisplayName("Test Product Id to be Unique")
    public void testTransactionIdUnique(){

        assertNotEquals(p1.getPid(),
                p2.getPid());
    }

    @Test
    @DisplayName("Product ID not negative or zero")
    public void testAmountToBePositive(int data){
        assertTrue(p1.getPid()>0);

    }


}
