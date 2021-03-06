package com.flashdin.belajarspringweb.dao.impl;

import com.flashdin.belajarspringweb.dao.MahasiswaDAO;
import com.flashdin.belajarspringweb.entity.Mahasiswa;
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
public class MahasiswaDAOImpl implements MahasiswaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Mahasiswa save(Mahasiswa param){
        String sql = "insert into table_students (name, address) values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getName());
            ps.setString(2, param.getAddress());

            return ps;
        }, keyHolder);
        param.setUSER_ID(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public Mahasiswa update(Mahasiswa param) {
        String sql = "update table_students set name=?,address=? where USER_ID=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getName());
            ps.setString(2, param.getAddress());
            ps.setInt(3, param.getUSER_ID());
            return ps;
        });
        param.setUSER_ID(rtn);
        return param;
    }

    @Override
    public int delete(Mahasiswa param) {
        String sql = "delete from table_students where USER_ID=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getUSER_ID());
            return ps;
        });
        return rtn;
    }

    @Override
    public Mahasiswa findById(int id) {
        String sql = "select * from table_students where USER_ID=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }

    @Override
    public List<Mahasiswa> findAll() {
        String sql = "select * from table_students";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }

    @Override
    public List<Mahasiswa> findByName(Mahasiswa param) {
        String sql = "select * from table_students where name like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getName() + "%"}, new BeanPropertyRowMapper<>(Mahasiswa.class));
    }
}



