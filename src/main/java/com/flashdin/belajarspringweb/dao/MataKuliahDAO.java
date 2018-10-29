package com.flashdin.belajarspringweb.dao;

import com.flashdin.belajarspringweb.entity.MataKuliah;

import java.util.List;

public interface MataKuliahDAO extends BaseDAO<MataKuliah> {
    List<MataKuliah> findByName(MataKuliah param);
}
