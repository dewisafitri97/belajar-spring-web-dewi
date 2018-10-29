package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspringweb.dao.MataKuliahDAO;
import com.flashdin.belajarspringweb.entity.MataKuliah;
import com.flashdin.belajarspringweb.service.MataKuliahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MataKuliahServiceImpl implements MataKuliahService {

    @Autowired
    private MataKuliahDAO mataKuliahDAO;

    @Override
    public MataKuliah save(@RequestBody MataKuliah param) {
        return mataKuliahDAO.save(param);
    }

    @Override
    public MataKuliah update(@RequestBody MataKuliah param) {
        return mataKuliahDAO.update(param);
    }

    @Override
    public int delete(@RequestBody MataKuliah param) {
        return mataKuliahDAO.delete(param);
    }

    @Override
    public MataKuliah findById(@PathVariable int id) {
        return mataKuliahDAO.findById(id);
    }

    @Override
    public List<MataKuliah> findAll() {
        return mataKuliahDAO.findAll();
    }

    @Override
    public List<MataKuliah> findByName(MataKuliah param) {
        return mataKuliahDAO.findByName(param);
    }

}
