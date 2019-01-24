package com.wz.dao;

import com.wz.entity.Ems;

import java.util.List;

public interface EmsDAO {
    List<Ems> selectAll();
    Ems selectOne(String id);
    void insert(Ems ems);
    void update(Ems ems);
    void delete(String id);
}
