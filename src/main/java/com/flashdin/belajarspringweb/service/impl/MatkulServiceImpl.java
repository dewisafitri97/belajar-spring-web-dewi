package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspringweb.dao.MatkulDAO;
import com.flashdin.belajarspringweb.entity.Matkul;
import com.flashdin.belajarspringweb.service.MatkulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MatkulServiceImpl implements MatkulService {

    @Autowired
    private MatkulDAO matkulDAO;

    @Override
    public Matkul save(@RequestBody Matkul param) {
        return matkulDAO.save(param);
    }

    @Override
    public Matkul update(@RequestBody Matkul param) {
        return matkulDAO.update(param);
    }

    @Override
    public int delete(@RequestBody Matkul param) {
        return matkulDAO.delete(param);
    }

    @Override
    public Matkul findById(@PathVariable int id) {
        return matkulDAO.findById(id);
    }

    @Override
    public List<Matkul> findAll() {
        return matkulDAO.findAll();
    }

    @Override
    public List<Matkul> findByName(Matkul param) {
        return matkulDAO.findByName(param);
    }

}
