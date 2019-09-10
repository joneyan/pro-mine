package com.jone.pro.app.wechat.abstrclass.msgreply;

import com.jone.pro.app.wechat.bo.MessageEntity;
import com.jone.pro.common.enums.wechat.WechatMsgTypeEnum;
import com.jone.pro.common.vo.WeChatGroupDetailVO;

import java.util.List;

/**
 * @author yanjing
 * @date 2019/9/10 8:41
 */
public abstract class AbstractMsgReply {
    public abstract String replyDeal(WechatMsgTypeEnum wechatMsgTypeEnum, String accessToken, MessageEntity messageEntity, List<String> opendIds, List<WeChatGroupDetailVO> groups, MessageEntity beanByXml);
}
