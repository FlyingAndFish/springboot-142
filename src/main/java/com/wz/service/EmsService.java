package com.wz.service;

import com.wz.entity.Ems;

import java.util.List;

public interface EmsService {
    List<Ems> queryAll();
    Ems queryOne(String id);
    void insert(Ems ems);
    void update(Ems ems);
    void delete(String id);
}
