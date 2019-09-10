package com.jone.pro.app.wechat.handler.msgreply;

import com.jone.pro.app.wechat.abstrclass.msgreply.AbstractMsgReply;
import com.jone.pro.app.wechat.abstrclass.msgreply.MsgReplyBaseHandler;
import com.jone.pro.app.wechat.bo.MessageEntity;
import com.jone.pro.app.wechat.decorate.msgreply.text.ExampleMsgReplyDecorate;
import com.jone.pro.common.enums.wechat.WechatMsgTypeEnum;
import com.jone.pro.common.vo.WeChatGroupDetailVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yanjing
 * 文本消息回复handler
 * @date 2019/9/10 8:54
 */
@Service("textMsgReplyHandler")
public class TextMsgReplyHandler extends MsgReplyBaseHandler {

    @Override
    public String decorateReply(WechatMsgTypeEnum wechatMsgTypeEnum, String accessToken, MessageEntity messageEntity, List<String> opendIds, List<WeChatGroupDetailVO> groups, MessageEntity beanByXml) {

        AbstractMsgReply msgReplyDecorate = new ExampleMsgReplyDecorate(this);
        return msgReplyDecorate.replyDeal(wechatMsgTypeEnum,accessToken,messageEntity,opendIds,groups,beanByXml);

    }

    @Override
    public String replyDeal(WechatMsgTypeEnum wechatMsgTypeEnum, String accessToken, MessageEntity messageEntity, List<String> opendIds, List<WeChatGroupDetailVO> groups, MessageEntity beanByXml) {
        //TODO bindToOneTag("对话",groups,tagId,opendIds,accessToken);
        // String content = beanByXml.getContent();
        // TODO 获取关键词消息
        //dealAboutKeyword(null,messageEntity);
        String xml = "";
        return dealXml(xml,messageEntity);
    }
}
