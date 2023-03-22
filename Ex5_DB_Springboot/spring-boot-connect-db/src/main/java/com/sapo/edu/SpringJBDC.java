package com.sapo.edu;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class SpringJBDC {
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ex03_mysql?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("hiep2309");

        return dataSource;
    }
}
