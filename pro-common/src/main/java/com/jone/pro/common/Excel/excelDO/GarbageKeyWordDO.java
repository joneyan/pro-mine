package com.jone.pro.common.Excel.excelDO;

import com.jone.pro.common.annotation.ParamsName;
import lombok.Data;

/**
 * @author yanjing
 * @date 2019/7/12 10:25
 */
@Data
public class GarbageKeyWordDO {

    @ParamsName(paramName = "关键词" , setMethodName = "setKeyWord")
    private String keyWord;

    public String getKeyWord() {
        return keyWord;
    }

    public GarbageKeyWordDO setKeyWord(String keyWord) {
        this.keyWord = keyWord;
        return this;
    }
}
