package com.jone.pro.mapper;

import com.jone.pro.entity.Garbage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yanjing
 * @since 2019-07-11
 */
public interface GarbageMapper extends BaseMapper<Garbage> {

    void batchInsert(@Param("garbageList") List<Garbage> garbageList);

    List<Garbage> selectAll();

    List<Garbage> selectListByParams(Map<String, Object> params);
}
