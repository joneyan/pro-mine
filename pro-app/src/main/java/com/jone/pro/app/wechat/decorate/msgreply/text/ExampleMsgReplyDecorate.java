package com.jone.pro.app.wechat.decorate.msgreply.text;

import com.jone.pro.app.wechat.abstrclass.msgreply.AbstractMsgReply;
import com.jone.pro.app.wechat.abstrclass.msgreply.AbstractMsgReplyDecorate;
import com.jone.pro.app.wechat.bo.MessageEntity;
import com.jone.pro.common.enums.wechat.WechatMsgTypeEnum;
import com.jone.pro.common.vo.WeChatGroupDetailVO;

import java.util.List;

/**
 * @author yanjing
 * @date 2019/9/10 8:57
 */
public class ExampleMsgReplyDecorate extends AbstractMsgReplyDecorate {
    public ExampleMsgReplyDecorate(AbstractMsgReply abstractMsgReply) {
        super(abstractMsgReply);
    }
    public void dealExample(){
        System.out.println("ExampleMsgReplyDecorate dealExample");
    }
    @Override
    public void decorate() {

    }

    @Override
    public String replyDeal(WechatMsgTypeEnum wechatMsgTypeEnum, String accessToken, MessageEntity messageEntity, List<String> opendIds, List<WeChatGroupDetailVO> groups, MessageEntity beanByXml) {
        this.dealExample();
        return super.replyDeal(wechatMsgTypeEnum, accessToken, messageEntity, opendIds, groups, beanByXml);
    }
}
