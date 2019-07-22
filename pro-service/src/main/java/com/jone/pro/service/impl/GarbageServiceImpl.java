package com.jone.pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.jone.pro.common.enums.GarbageTypeStyleEnum;
import com.jone.pro.entity.Garbage;
import com.jone.pro.mapper.GarbageMapper;
import com.jone.pro.service.GarbageService;
import com.jone.pro.vo.GarbageSearchVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yanjing
 * @since 2019-07-11
 */
@Service
public class GarbageServiceImpl implements GarbageService {

    @Autowired
    private GarbageMapper garbageMapper;
    @Override
    public Boolean batchSave(List<Garbage> garbageList) {
        garbageMapper.batchInsert(garbageList);
        return Boolean.TRUE;
    }

    @Override
    public void save(Garbage garbage) {
        garbageMapper.insert(garbage);
    }

    @Override
    public List<Garbage>  getAll() {
        List<Garbage> garbage = garbageMapper.selectAll();
        return garbage;
    }

    @Override
    public List<GarbageSearchVO> searchGarbage(Garbage garbage) {
        List<GarbageSearchVO> garbageSearchVOList = Lists.newArrayList();
        Map<String, Object> params = new HashMap<>();
        params.put("keyWord",garbage.getGarbageName());
        params.put("typeId",garbage.getTypeId());
        List<Garbage> garbageList = garbageMapper.selectListByParams(params);
        if (CollectionUtils.isNotEmpty(garbageList)){
            garbageList.forEach(item->{
                GarbageTypeStyleEnum instance = GarbageTypeStyleEnum.getInstance(item.getTypeId());
                GarbageSearchVO garbageSearchVO = new GarbageSearchVO();
                garbageSearchVO.setId(item.getId());
                garbageSearchVO.setName(item.getGarbageName());

                garbageSearchVO.setTypeName(instance.getDesc());
                garbageSearchVO.setTypeStyle(instance.getCode());
                garbageSearchVOList.add(garbageSearchVO);
            });
        }
        return garbageSearchVOList;
    }
}
