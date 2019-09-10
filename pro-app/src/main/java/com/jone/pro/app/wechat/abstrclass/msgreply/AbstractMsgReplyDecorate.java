package com.jone.pro.app.wechat.abstrclass.msgreply;

import com.jone.pro.app.wechat.bo.MessageEntity;
import com.jone.pro.common.enums.wechat.WechatMsgTypeEnum;
import com.jone.pro.common.vo.WeChatGroupDetailVO;
import lombok.Data;

import java.util.List;

/**
 * @author yanjing
 * @date 2019/9/10 8:43
 */
@Data
public abstract class AbstractMsgReplyDecorate extends AbstractMsgReply{
    private AbstractMsgReply abstractMsgReply;
    public abstract void decorate();

    public AbstractMsgReplyDecorate(AbstractMsgReply abstractMsgReply) {
        this.abstractMsgReply = abstractMsgReply;
    }

    @Override
    public String replyDeal(WechatMsgTypeEnum wechatMsgTypeEnum, String accessToken, MessageEntity messageEntity, List<String> opendIds, List<WeChatGroupDetailVO> groups, MessageEntity beanByXml) {
        return this.abstractMsgReply.replyDeal(wechatMsgTypeEnum, accessToken, messageEntity, opendIds, groups, beanByXml);
    }
}
