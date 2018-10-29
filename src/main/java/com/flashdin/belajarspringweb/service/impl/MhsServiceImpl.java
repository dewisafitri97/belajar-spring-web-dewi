package com.flashdin.belajarspringweb.service.impl;

import com.flashdin.belajarspringweb.dao.MhsDAO;
import com.flashdin.belajarspringweb.entity.Mhs;
import com.flashdin.belajarspringweb.entity.Profile;
import com.flashdin.belajarspringweb.service.MhsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class MhsServiceImpl implements MhsService {
    @Autowired
    private MhsDAO mhsDAO;

    @Override
    public Mhs save(@RequestBody Mhs param){return mhsDAO.save(param);}

    @Override
    public Mhs update(@RequestBody Mhs param) {
        return mhsDAO.update(param);
    }

    @Override
    public int delete(@RequestBody Mhs param) {
        return mhsDAO.delete(param);
    }

    @Override
    public Mhs findById(@PathVariable int id) {
        return mhsDAO.findById(id);
    }

    @Override
    public List<Mhs> findAll() {
        return mhsDAO.findAll();
    }

    @Override
    public List<Mhs> findByName(Mhs param) {
        return mhsDAO.findByName(param);
    }

}
