package com.wz.test;

import com.wz.Application;
import com.wz.dao.EmsDAO;
import com.wz.entity.Ems;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestDAO {
    @Autowired
    private EmsDAO emsDAO;

    @Test
    public void test1(){
        List<Ems> ems = emsDAO.selectAll();
        for (Ems em : ems) {
            System.out.println(em);
        }
    }
}
