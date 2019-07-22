package com.jone.pro.admin.controller.garbage.request;

import com.jone.pro.common.base.ParamsObject;
import com.jone.pro.common.enums.SearchTypeEnum;
import com.jone.pro.common.enums.error.ParamsValidateErrorEnum;
import com.jone.pro.common.exception.ApplicationException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author yanjing
 * @date 2019/7/19 8:57
 */
@Data
public class SearchGarbageRequest extends ParamsObject {
    private String keyWord;
    private String typeId;
    private String searchType;

    @Override
    public void validate() {
        if (Objects.equals(SearchTypeEnum.KEY_WORD.getCode(),searchType) && StringUtils.isEmpty(keyWord)){
            throw new ApplicationException(ParamsValidateErrorEnum.SEARCH_KEY_WORD_LOSE);
        }

        if (Objects.equals(SearchTypeEnum.TYPE_ID.getCode(),searchType) && StringUtils.isEmpty(typeId)){
            throw new ApplicationException(ParamsValidateErrorEnum.TYPE_ID_WORD_LOSE);
        }
    }
}
