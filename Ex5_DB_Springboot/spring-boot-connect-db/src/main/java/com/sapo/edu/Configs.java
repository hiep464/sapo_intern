package com.sapo.edu;

import org.springframework.jdbc.core.JdbcTemplate;

import java.time.format.DateTimeFormatter;

public class Configs {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static SpringJBDC jbdc = new SpringJBDC();
    public static final JdbcTemplate jdbcTemplate = new JdbcTemplate(jbdc.mysqlDataSource());

    // CONFIGS TABLE NAME
    public static final String INVENTORY_TABLE = "Inventory";
    public static final String CATEGORY_TABLE = "Category";
    public static final String PRODUCT_TABLE = "Product";
}
