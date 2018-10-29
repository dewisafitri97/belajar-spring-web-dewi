package com.flashdin.belajarspringweb.dao;

import com.flashdin.belajarspringweb.entity.Mhs;

import java.util.List;

public interface MhsDAO extends BaseDAO<Mhs> {
    List<Mhs> findByName(Mhs param);
}
