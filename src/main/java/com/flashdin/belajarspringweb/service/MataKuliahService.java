package com.flashdin.belajarspringweb.service;

import com.flashdin.belajarspringweb.entity.MataKuliah;

import java.util.List;

public interface MataKuliahService extends BaseService<MataKuliah> {
    List<MataKuliah> findByName(MataKuliah param);
}
