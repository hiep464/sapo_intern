package com.sapo.edu.dao;

import com.sapo.edu.Configs;
import com.sapo.edu.entities.Inventory;
import com.sapo.edu.entities.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductDao implements Dao<Product> {

    private String TABLE_NAME = Configs.PRODUCT_TABLE;

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * from " + TABLE_NAME;
        return Configs.jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product product = new Product(resultSet.getInt("id"), resultSet.getString("product_code"),
                        resultSet.getInt("category_id"), resultSet.getInt("inventory_id"),
                        resultSet.getString("product_name"), resultSet.getString("description"),
                        resultSet.getString("image_path"), resultSet.getInt("quantity"),
                        resultSet.getInt("sold"), resultSet.getString("price"),
                        resultSet.getString("created_at"), resultSet.getString("updated_at"));
                return product;
            }
        });
    }

    @Override
    public Product get(int id) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
