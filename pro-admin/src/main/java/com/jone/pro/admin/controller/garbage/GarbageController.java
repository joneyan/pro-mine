package com.jone.pro.admin.controller.garbage;


import com.jone.pro.entity.Garbage;
import com.jone.pro.service.GarbageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yanjing
 * @since 2019-07-11
 */
@RestController
@RequestMapping("/garbage")
public class GarbageController {

    @Autowired
    private GarbageService garbageService;

    @PostMapping("/save")
    public Boolean save(@RequestBody Garbage garbage){
        garbageService.save(garbage);
        return Boolean.TRUE;
    }

    @PostMapping("/get")
    public List<Garbage> save(){
       return garbageService.getAll();
    }
}

