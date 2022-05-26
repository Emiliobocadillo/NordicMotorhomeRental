package com.example.springpractice.motorhome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorhomeRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Motorhome> findAllByType(int type) {
        String sql = "select name, make, model, beds, price from motorhome where type = ? ";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.query(sql, rowMapper, type);
    }
}
