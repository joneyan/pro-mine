package com.jone.pro.app.wechat.abstrclass.msgreply;

import com.jone.pro.app.wechat.bo.Article;
import com.jone.pro.app.wechat.bo.Item;
import com.jone.pro.app.wechat.bo.MessageEntity;
import com.jone.pro.common.enums.wechat.WechatMsgTypeEnum;
import com.jone.pro.common.utils.JSONUtils;
import com.jone.pro.common.utils.XmlBeanUtils;
import com.jone.pro.common.vo.KeywordMsgReplyContentVO;
import com.jone.pro.common.vo.WeChatGroupDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.jone.pro.common.enums.wechat.WechatMsgTypeEnum.NEWS;

/**
 * @author yanjing
 * @date 2019/9/10 8:51
 */
@Component
@Slf4j
public abstract class MsgReplyBaseHandler extends AbstractMsgReply {
    public abstract String decorateReply(WechatMsgTypeEnum wechatMsgTypeEnum, String accessToken, MessageEntity messageEntity, List<String> opendIds, List<WeChatGroupDetailVO> groups, MessageEntity beanByXml);

    /**
     * 处理回复消息
     *
     * @param keywordMsgReplyContentVO
     * @param messageEntity
     */
    protected void dealAboutKeyword(KeywordMsgReplyContentVO keywordMsgReplyContentVO, MessageEntity messageEntity) {
        Integer msgType = keywordMsgReplyContentVO.getMsgType();
        String message = keywordMsgReplyContentVO.getMessage();
        WechatMsgTypeEnum wechatMsgTypeEnum = WechatMsgTypeEnum.getEnumByType(msgType);
        if (Objects.equals(wechatMsgTypeEnum,WechatMsgTypeEnum.TEXT)){
            messageEntity.setMsgType(wechatMsgTypeEnum.getValues());
            messageEntity.setContent(message);
            return;
        }

        if (Objects.equals(wechatMsgTypeEnum,WechatMsgTypeEnum.TEXT)){
            messageEntity.setMsgType(wechatMsgTypeEnum.getValues());
            messageEntity.setContent(message);
            return;
        }

        if (Objects.equals(wechatMsgTypeEnum,WechatMsgTypeEnum.NEWS)){
            messageEntity.setMsgType(wechatMsgTypeEnum.getValues());
            Article article =null;
            try {
                article = JSONUtils.json2pojo(message, Article.class);

            } catch (Exception e) {
                log.error("JSON转换失败---dealAboutKeyword---errorMessage:{}",e.getMessage());
            }
            messageEntity.setArticleCount(1);
            List<Item> items = new ArrayList<>();
            Item item = new Item();
            item.setItem(article);
            items.add(item);
            messageEntity.setArticles(items);
            return;
        }

        if (Objects.equals(wechatMsgTypeEnum,WechatMsgTypeEnum.IMAGE)){
            messageEntity.setMsgType(wechatMsgTypeEnum.getValues());
            messageEntity.setMediaId(message);
            return;
        }
    }

    /**
     * 处理返回的xml
     * @param xml
     * @param messageEntity
     */
    protected String dealXml(String xml ,MessageEntity messageEntity){
        xml = XmlBeanUtils.getXmlByBean(messageEntity, String.class);
        /**如果是图文消息的时候转换成xml需要把这两行去掉**/
        String replace = xml.replace("<com.jone.pro.app.wechat.bo.MessageEntity>", "");
        String finalXml = replace.replace("</com.jone.pro.app.wechat.bo.MessageEntity>", "");
        return finalXml;
    }
}
