package com.jone.pro.common.vo;


import java.io.Serializable;

/**
 * @Author: yanjing
 * @Date: 2018/11/28 上午10:31
 * @Description:
 */
public class KeywordMsgReplyContentVO implements Serializable {
    private Long id;

    private String keyword;

    private Integer msgType;

    private String message;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
