package com.sapo.edu.dao;

import com.sapo.edu.entities.Inventory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sapo.edu.Configs;

public class InventoryDao implements Dao<Inventory> {

    private String TABLE_NAME = Configs.INVENTORY_TABLE;

    @Override
    public List<Inventory> getAll() {
        String sql = "SELECT * from " + TABLE_NAME;
        return Configs.jdbcTemplate.query(sql, new RowMapper<Inventory>() {
            @Override
            public Inventory mapRow(ResultSet resultSet, int i) throws SQLException {
                Inventory inventory = new Inventory(resultSet.getInt("id"), resultSet.getString("inventory_code"),
                        resultSet.getString("inventory_name"), resultSet.getString("location"),
                        resultSet.getString("created_at"), resultSet.getString("updated_at"));
                return inventory;
            }
        });
    }

    @Override
    public Inventory get(int id) {
        return null;
    }

    @Override
    public void save(Inventory i) {
        String sql = "Insert into " + TABLE_NAME +
                "(id, inventory_code, inventory_name, location, created_at, updated_at) values (?, ?, ?, ?, ?, ?)";
        Configs.jdbcTemplate.update(sql, i.getId(), i.getInventoryCode(), i.getInventoryName(), i.getLocation(), i.getCreatedAt(), i.getUpdatedAt());
        System.out.println(i.toString());
    }

    @Override
    public void update(Inventory i) {
        String sql = "Update " + TABLE_NAME +
                " SET id = ?, inventory_code = ?, inventory_name = ?, location = ?, created_at = ?, updated_at = ? " +
                "where id = " + i.getId();
        Configs.jdbcTemplate.update(sql, i.getId(), i.getInventoryCode(), i.getInventoryName(),
                i.getLocation(), i.getCreatedAt(), i.getUpdatedAt());
        System.out.println(i.toString());
    }

    @Override
    public void delete(Inventory i) {
        String sql = "Delete from " +TABLE_NAME + " where id = "+i.getId();
        Configs.jdbcTemplate.execute(sql);
        System.out.println(i.toString());
    }
}
