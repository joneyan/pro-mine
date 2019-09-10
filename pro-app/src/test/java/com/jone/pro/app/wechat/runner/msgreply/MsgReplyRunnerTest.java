package com.jone.pro.app.wechat.runner.msgreply;

import com.jone.pro.app.wechat.bo.MessageEntity;
import com.jone.pro.common.enums.wechat.WechatMsgTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yanjing
 * @date 2019/9/10 11:41
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MsgReplyRunnerTest {

    @Autowired
    private MsgReplyRunner msgReplyRunner;
    @Test
    public void run() {
        WechatMsgTypeEnum text = WechatMsgTypeEnum.TEXT;
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setArticleCount(1);
        messageEntity.setContent("222222");
        messageEntity.setFromUserName("joneyan");
        String run = msgReplyRunner.run(text, null,messageEntity , null, null, null);
        System.out.println(run);
    }
}