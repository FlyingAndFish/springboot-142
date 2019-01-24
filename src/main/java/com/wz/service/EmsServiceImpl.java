package com.wz.service;

import com.wz.dao.EmsDAO;
import com.wz.entity.Ems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service("emsService")
@Transactional
public class EmsServiceImpl implements EmsService {
    @Autowired
    private EmsDAO emsDAO;

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Ems> queryAll() {
        List<Ems> emss = emsDAO.selectAll();
        return emss;
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Ems queryOne(String id) {
        Ems ems = emsDAO.selectOne(id);
        return ems;
    }

    @Override
    public void insert(Ems ems) {
        String s = UUID.randomUUID().toString();
        String replace = s.replace("-", "");
        ems.setId(replace);
        System.out.println(ems);
        emsDAO.insert(ems);
    }

    @Override
    public void update(Ems ems) {
        emsDAO.update(ems);
    }

    @Override
    public void delete(String id) {
        emsDAO.delete(id);
    }
}
