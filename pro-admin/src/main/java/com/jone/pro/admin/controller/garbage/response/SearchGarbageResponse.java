package com.jone.pro.admin.controller.garbage.response;

import com.jone.pro.vo.GarbageSearchVO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yanjing
 * @date 2019/7/19 8:58
 */
@Data
public class SearchGarbageResponse implements Serializable {
    private List<GarbageSearchVO> garbageSearchVOS;

    public SearchGarbageResponse(List<GarbageSearchVO> garbageSearchVOS) {
        this.garbageSearchVOS = garbageSearchVOS;
    }
}
