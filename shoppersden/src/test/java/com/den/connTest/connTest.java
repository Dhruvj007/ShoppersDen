package com.den.connTest;

import com.den.helper.PostgresConnHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Connection;
import java.sql.SQLException;

public class connTest {

    private static Connection conn;

    @BeforeAll
    static void connDB() {
        conn= PostgresConnHelper.getConnection();
    }

    @Test
    void connCheck(){
        assertNotEquals(conn,null);
    }

    @AfterAll
    static void disconnDB() throws SQLException {
        conn.close();
    }




}
