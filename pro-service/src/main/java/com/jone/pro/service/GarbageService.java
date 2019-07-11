package com.jone.pro.service;

import com.jone.pro.entity.Garbage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yanjing
 * @since 2019-07-11
 */
public interface GarbageService{
    Boolean batchSave(List<Garbage> garbageList);

    void save(Garbage garbage);

    void getAll();
}
