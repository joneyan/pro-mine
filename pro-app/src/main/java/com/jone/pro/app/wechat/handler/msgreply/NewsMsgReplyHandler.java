package com.jone.pro.app.wechat.handler.msgreply;

import com.jone.pro.app.wechat.abstrclass.msgreply.MsgReplyBaseHandler;
import com.jone.pro.app.wechat.bo.MessageEntity;
import com.jone.pro.common.enums.wechat.WechatMsgTypeEnum;
import com.jone.pro.common.vo.WeChatGroupDetailVO;

import java.util.List;

/**
 * @author yanjing
 * @date 2019/9/10 14:59
 */
public class NewsMsgReplyHandler extends MsgReplyBaseHandler {
    @Override
    public String decorateReply(WechatMsgTypeEnum wechatMsgTypeEnum, String accessToken, MessageEntity messageEntity, List<String> opendIds, List<WeChatGroupDetailVO> groups, MessageEntity beanByXml) {
        return null;
    }

    @Override
    public String replyDeal(WechatMsgTypeEnum wechatMsgTypeEnum, String accessToken, MessageEntity messageEntity, List<String> opendIds, List<WeChatGroupDetailVO> groups, MessageEntity beanByXml) {
        return null;
    }
}
