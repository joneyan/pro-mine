package com.jone.pro.common.enums.wechat;

import org.springframework.http.HttpStatus;

/**
 * @Author: yanjing
 * @Date: 2018/11/23 下午2:48
 * @Description:
 */
public enum  WeChatFileErrorEnum implements ErrorCodeEnum {
    IMAGE_SIZE_OUT(17001,"图片超过规定大小(小于2M)"),
    VOICE_SIZE_OUT(17002,"语音超过规定大小(小于2M)"),
    VIDEO_SIZE_OUT(17003,"视频超过规定大小(小于10M)"),
    THUMB_SIZE_OUT(17004,"缩略图超过规定大小(小于64K)"),
    IMAGE_TYPE_ERROR(17005,"图片格式不支持（支持bmp/png/jpeg/jpg/gif格式）"),
    VOICE_TYPE_ERROR(17006,"语音格式不支持（支持mp3/wma/wav/amr）"),
    VIDEO_TYPE_ERROR(17007,"视频格式不支持（支持mp4)"),
    THUMB_TYPE_ERROR(17008,"缩略图格式不支持（支持jpg)"),
    NOT_SUPPORT_TYPE(17009,"不支持该文件类型素材"),
    ;


    private Integer code;

    private String msg;

    WeChatFileErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getMsg() {
        return null;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return null;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
