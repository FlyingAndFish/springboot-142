package com.wz.test;

import com.wz.entity.Ems;
import org.junit.Test;

import java.util.Date;

public class TestEntity {
    @Test
    public void test1(){
        Ems ems = new Ems();
        ems.setBirthday(new Date());
        System.out.println(ems);
    }
}
