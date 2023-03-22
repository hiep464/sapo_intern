package com.sapo.edu.dao;

import com.sapo.edu.Configs;
import com.sapo.edu.entities.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CategoryDao implements Dao<Category>{

    private String TABLE_NAME = Configs.CATEGORY_TABLE;

    @Override
    public List<Category> getAll() {
        String sql = "SELECT * from " + TABLE_NAME;
        return Configs.jdbcTemplate.query(sql, new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet resultSet, int i) throws SQLException {
                Category category = new Category(resultSet.getInt("id"), resultSet.getString("category_code"),
                        resultSet.getString("category_name"), resultSet.getString("description"),
                        resultSet.getString("created_at"), resultSet.getString("updated_at"));
                return category;
            }
        });
    }

    @Override
    public Category get(int id) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(Category category) {

    }
}
