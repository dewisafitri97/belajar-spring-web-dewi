package com.flashdin.belajarspringweb.service;

import com.flashdin.belajarspringweb.entity.Matkul;

import java.util.List;

public interface MatkulService extends BaseService<Matkul> {
    List<Matkul> findByName(Matkul param);
}
