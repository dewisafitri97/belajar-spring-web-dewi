package com.flashdin.belajarspringweb.dao.impl;

import com.flashdin.belajarspringweb.dao.MatkulDAO;
import com.flashdin.belajarspringweb.entity.Matkul;
import com.flashdin.belajarspringweb.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MatkulDAOImpl implements MatkulDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Matkul save(Matkul param) {
        String sql = "insert into table_makul (makul) values (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getMakul());

            return ps;
        }, keyHolder);
        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public Matkul update(Matkul param) {
        String sql = "update table_makul set makul=? where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getMakul());
            ps.setInt(2, param.getId());
            return ps;
        });
        param.setId(rtn);
        return param;
    }

    @Override
    public int delete(Matkul param) {
        String sql = "delete from table_makul where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getId());
            return ps;
        });
        return rtn;
    }

    @Override
    public Matkul findById(int id) {
        String sql = "select * from table_makul where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Matkul.class));
    }

    @Override
    public List<Matkul> findAll() {
        String sql = "select * from table_makul";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Matkul.class));
    }

    @Override
    public List<Matkul> findByName(Matkul param) {
        String sql = "select * from table_makul where makul like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getMakul() + "%"}, new BeanPropertyRowMapper<>(Matkul.class));
    }

}
