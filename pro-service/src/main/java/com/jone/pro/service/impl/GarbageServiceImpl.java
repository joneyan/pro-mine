package com.jone.pro.service.impl;

import com.jone.pro.entity.Garbage;
import com.jone.pro.mapper.GarbageMapper;
import com.jone.pro.service.GarbageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
}
