package com.flashdin.belajarspringweb.dao.impl;

import com.flashdin.belajarspringweb.dao.MataKuliahDAO;
import com.flashdin.belajarspringweb.entity.MataKuliah;
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
public class MataKuliahDAOImpl implements MataKuliahDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public MataKuliah save(MataKuliah param) {
        String sql = "insert into table_makul (makul) values (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getMakul());

            return ps;
        }, keyHolder);
        param.setUSER_ID(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public MataKuliah update(MataKuliah param) {
        String sql = "update table_makul set makul=? where USER_ID=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getMakul());
            ps.setInt(2, param.getUSER_ID());
            return ps;
        });
        param.setUSER_ID(rtn);
        return param;
    }

    @Override
    public int delete(MataKuliah param) {
        String sql = "delete from table_makul where USER_ID=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getUSER_ID());
            return ps;
        });
        return rtn;
    }

    @Override
    public MataKuliah findById(int id) {
        String sql = "select * from table_makul where USER_ID=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(MataKuliah.class));
    }

    @Override
    public List<MataKuliah> findAll() {
        String sql = "select * from table_makul";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(MataKuliah.class));
    }

    @Override
    public List<MataKuliah> findByName(MataKuliah param) {
        String sql = "select * from table_makul where makul like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getMakul() + "%"}, new BeanPropertyRowMapper<>(MataKuliah.class));
    }

}
