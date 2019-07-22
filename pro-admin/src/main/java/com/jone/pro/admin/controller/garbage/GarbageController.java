package com.jone.pro.admin.controller.garbage;


import com.jone.pro.admin.controller.garbage.request.SearchGarbageRequest;
import com.jone.pro.admin.controller.garbage.response.SearchGarbageResponse;
import com.jone.pro.common.annotation.ParamsValidate;
import com.jone.pro.common.base.ProResponse;
import com.jone.pro.entity.Garbage;
import com.jone.pro.service.GarbageService;
import com.jone.pro.vo.GarbageSearchVO;
import org.apache.commons.lang3.StringUtils;
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

    @PostMapping("/search")
    @ParamsValidate
    public ProResponse<SearchGarbageResponse> search(@RequestBody SearchGarbageRequest searchGarbageRequest){
        Garbage garbage = new Garbage();
        garbage.setGarbageName(searchGarbageRequest.getKeyWord());
        if (StringUtils.isNotEmpty(searchGarbageRequest.getTypeId())){
            garbage.setTypeId(Long.parseLong(searchGarbageRequest.getTypeId()));
        }
        List<GarbageSearchVO> garbageSearchVOS = garbageService.searchGarbage(garbage);
        return new ProResponse(new SearchGarbageResponse(garbageSearchVOS));
    }
}

