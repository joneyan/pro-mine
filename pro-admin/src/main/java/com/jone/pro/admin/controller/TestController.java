package com.jone.pro.admin.controller;

import com.jone.pro.admin.elasticsearch.ArticleSearchRepository;
import com.jone.pro.admin.elasticsearch.Pepole;
import com.jone.pro.admin.vo.request.AopRequst;
import com.jone.pro.common.annotation.ParamsValidate;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @Author: yanjing
 * @Date: 2019/4/9 下午3:06
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ArticleSearchRepository articleSearchRepository;

    @RequestMapping(value = "/query/{queryString}")
    public String query(@PathVariable(name = "queryString") String str){
        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name",str);
        Iterable<Pepole> search = articleSearchRepository.search(fuzzyQueryBuilder);
        Iterator<Pepole> iterator = search.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }
        return "success";
    }

    @RequestMapping(value = "/save")
    public String save(){
        Pepole pepole = new Pepole();
        pepole.setId(22222l);
        pepole.setName("yanjing");
        pepole.setOld(100);
        articleSearchRepository.save(pepole);
        return "success";
    }

    @RequestMapping(value = "/aop",method = RequestMethod.POST)
    @ParamsValidate
    public String testAop(@RequestBody AopRequst aopRequst){
        return "success";
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (Integer i=0;i<=20;i++){
            map.put(i+"",i+"");
        }

    }
}
