package com.jone.pro.service;

import com.jone.pro.entity.Garbage;
import com.jone.pro.vo.GarbageSearchVO;

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

    List<Garbage> getAll();

    List<GarbageSearchVO> searchGarbage(Garbage garbage);
}
