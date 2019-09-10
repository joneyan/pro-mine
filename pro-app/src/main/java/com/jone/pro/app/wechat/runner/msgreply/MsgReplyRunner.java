package com.jone.pro.app.wechat.runner.msgreply;

import com.jone.pro.app.wechat.abstrclass.msgreply.MsgReplyBaseHandler;
import com.jone.pro.app.wechat.bo.MessageEntity;
import com.jone.pro.common.enums.wechat.WechatMsgTypeEnum;
import com.jone.pro.common.vo.WeChatGroupDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author yanjing
 * @date 2019/9/10 9:41
 */
@Component
public class MsgReplyRunner {
    @Autowired
    private Map<String, MsgReplyBaseHandler> handlerMap;

    public String run(WechatMsgTypeEnum wechatMsgTypeEnum, String accessToken, MessageEntity messageEntity, List<String> opendIds, List<WeChatGroupDetailVO> groups, MessageEntity beanByXml){
        MsgReplyBaseHandler msgReplyBaseHandler = handlerMap.get(wechatMsgTypeEnum.getHandlerName());
        if (msgReplyBaseHandler != null){
            return msgReplyBaseHandler.decorateReply(wechatMsgTypeEnum,accessToken,messageEntity,opendIds,groups,beanByXml);
        }
        return null;
    }
}
