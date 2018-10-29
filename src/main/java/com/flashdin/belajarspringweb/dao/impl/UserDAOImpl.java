package com.flashdin.belajarspringweb.dao.impl;

import com.flashdin.belajarspringweb.dao.UserDAO;
import com.flashdin.belajarspringweb.entity.User;
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
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User save(User param) {
        String sql = "insert into app_user (USER_NAME,ENCRYTED_PASSWORD) values (?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getUSER_NAME());
            ps.setString(2, param.getENCRYTED_PASSWORD());
            return ps;
        }, keyHolder);
        param.setUSER_ID(keyHolder.getKey().intValue());
        return param;
    }

    @Override
    public User update(User param) {
        String sql = "update app_user set USER_NAME=?,ENCRYTED_PASSWORD=? where USER_ID=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getUSER_NAME());
            ps.setString(2, param.getENCRYTED_PASSWORD());
            ps.setInt(3, param.getUSER_ID());
            return ps;
        });
        param.setUSER_ID(rtn);
        return param;
    }

    @Override
    public int delete(User param) {
        String sql = "delete from app_user where USER_ID=?";
        int rtn = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, param.getUSER_ID());
            return ps;
        });
        return rtn;
    }

    @Override
    public User findById(int id) {
        String sql = "select USER_ID, USER_NAME, ENCRYTED_PASSWORD from app_user where USER_ID=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public List<User> findAll() {
        String sql = "select USER_ID, USER_NAME, ENCRYTED_PASSWORD from app_user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public List<User> findByUsername(User param) {
        String sql = "select * from app_user where USER_NAME like ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + param.getUSER_NAME() + "%"}, new BeanPropertyRowMapper<>(User.class));
    }
}
