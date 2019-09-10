package com.jone.pro.app.wechat.controller;

import com.jone.pro.app.wechat.application.WeChatGroupUtils;
import com.jone.pro.app.wechat.bo.CheckEntity;
import com.jone.pro.app.wechat.bo.MessageEntity;
import com.jone.pro.app.wechat.runner.msgreply.MsgReplyRunner;
import com.jone.pro.common.vo.WeChatGroupDetailVO;
import com.jone.pro.common.enums.wechat.WechatMsgTypeEnum;
import com.jone.pro.common.utils.XmlBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author yanjing
 * @date 2019/9/10 10:04
 */
@RestController
@RequestMapping("/wechat/call/back")
@Slf4j
public class WechatController {
    @Autowired
    private MsgReplyRunner msgReplyRunner;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @RequestMapping(method = RequestMethod.GET)
    public String doCheck(@ModelAttribute CheckEntity entity, HttpServletResponse response){
        log.info("校验请求进来了-------------------");
        log.info(entity.toString());
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if(entity == null){
            log.info("没有传入参数！");
            return null;
        }
        String echostr = entity.getEchostr();
        String nonce = entity.getNonce();
        String signature = entity.getSignature();
        String timestamp = entity.getTimestamp();
        String[] strs=new String[]{timestamp,nonce,"wexin"};
        String finalStr = "";
        Arrays.sort(strs);
        for(String item:strs){
            finalStr+=item;
        }
        log.info("加密前："+finalStr);
        messageDigest.update(finalStr.getBytes());

        String formattedText = getFormattedText(messageDigest.digest());
        log.info("加密后"+formattedText);
        log.info("比较结果"+(formattedText.equals(signature)));
        if(formattedText.equals(signature)){
            return echostr;
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getResponse(HttpServletRequest request, HttpServletResponse response, @RequestParam String wxAccount){
        BufferedReader in=null;
        InputStream inputStream=null;
        StringBuilder stringBuilder = new StringBuilder();
        getPostMsg(inputStream,stringBuilder,request,in);
        String msg = stringBuilder.toString();

        if(!StringUtils.isEmpty(msg)){
            MessageEntity beanByXml =  XmlBeanUtils.getBeanByXml(msg, MessageEntity.class);
            String msgType = beanByXml.getMsgType();
            String accessToken = "";
            String openId = beanByXml.getFromUserName();
            String xml="";
            MessageEntity messageEntity = new MessageEntity();
            messageEntity.setFromUserName(beanByXml.getToUserName());
            messageEntity.setToUserName(beanByXml.getFromUserName());
            messageEntity.setCreateTime((int)(System.currentTimeMillis()/1000));
            List<String> opendIds = new ArrayList<>();
            opendIds.add(openId);
            Integer tagId=null;
            WechatMsgTypeEnum wechatMsgTypeEnum = WechatMsgTypeEnum.getEnumByValue(msgType);
            List<WeChatGroupDetailVO> groups = WeChatGroupUtils.getGroups(accessToken);
            msgReplyRunner.run(wechatMsgTypeEnum,accessToken,messageEntity,opendIds,groups,beanByXml);
            return xml;
        }
        return  null;
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    private void getPostMsg(InputStream inputStream, StringBuilder stringBuilder , HttpServletRequest request, BufferedReader in){
        try {

            inputStream  = request.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String s;
            while ((s=in.readLine())!=null){
                stringBuilder.append(s);
            }

        } catch (IOException e) {
            log.error(e.getMessage());
        }finally {
            if(in !=null){
                try {
                    in.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }
}
