package com.flashdin.belajarspringweb.service;

import com.flashdin.belajarspringweb.entity.Mhs;

import java.util.List;

public interface MhsService extends BaseService<Mhs> {
    List<Mhs> findByName(Mhs param);
}
