package com.flashdin.belajarspringweb.dao.impl;

import com.flashdin.belajarspringweb.dao.MhsDAO;
import com.flashdin.belajarspringweb.entity.Mhs;
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
public class MhsDAOImpl implements MhsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Mhs save(Mhs param){
        String sql = "insert into table_students (name, address) values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getName());
            ps.setString(2, param.getAddress());

            return ps;
        }, keyHolder);
        param.setId(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public Mhs update(Mhs param) {
        String sql = "update table_students set name=?,address=? where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getName());
            ps.setString(2, param.getAddress());
            ps.setInt(3, param.getId());
            return ps;
        });
        param.setId(rtn);
        return param;
    }

    @Override
    public int delete(Mhs param) {
        String sql = "delete from table_students where id=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getId());
            return ps;
        });
        return rtn;
    }

    @Override
    public Mhs findById(int id) {
        String sql = "select * from table_students where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<>(Mhs.class));
    }

    @Override
    public List<Mhs> findAll() {
        String sql = "select * from table_students";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Mhs.class));
    }

    @Override
    public List<Mhs> findByName(Mhs param) {
        String sql = "select * from table_students where name like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getName() + "%"}, new BeanPropertyRowMapper<>(Mhs.class));
    }
}



