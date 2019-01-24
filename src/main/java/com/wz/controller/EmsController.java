package com.wz.controller;

import com.wz.entity.Ems;
import com.wz.service.EmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("ems")
public class EmsController {
    @Autowired
    private EmsService emsService;

    @RequestMapping("showAll")
    @ResponseBody
    public List<Ems> showAll(){
        List<Ems> ems = emsService.queryAll();
        return ems;
    }

    @RequestMapping("showOne")
    @ResponseBody
    public Ems showOne(String id){
        Ems ems = emsService.queryOne(id);
        return ems;
    }

    @RequestMapping("addEms")
    @ResponseBody
    public void addEms(Ems ems){
        emsService.insert(ems);
    }

    @RequestMapping("modifyEms")
    @ResponseBody
    public void modifyEms(Ems ems){
        emsService.update(ems);
    }

    @RequestMapping("removeEms")
    @ResponseBody
    public void removeEms(String id){
        emsService.delete(id);
    }

}
