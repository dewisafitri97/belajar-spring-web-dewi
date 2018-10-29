package com.flashdin.belajarspringweb.dao;

import com.flashdin.belajarspringweb.entity.Matkul;

import java.util.List;

public interface MatkulDAO extends BaseDAO<Matkul> {
    List<Matkul> findByName(Matkul param);
}
