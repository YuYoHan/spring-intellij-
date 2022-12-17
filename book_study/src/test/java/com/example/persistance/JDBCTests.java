package com.example.persistance;


import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import java.sql.Connection;
import java.sql.DriverManager;

@Log4j
public class JDBCTests {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {
        try(Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/web0315",
                "root",
                "1234")) {
            log.info(con);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
