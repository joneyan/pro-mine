package com.jone.pro.app.wechat.application;

import com.jone.pro.common.vo.WeChatGroupDetailVO;
import com.jone.pro.common.enums.wechat.WxApiUrlEnum;
import com.jone.pro.common.utils.HttpClientUtils;
import com.jone.pro.common.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author: yanjing
 * @Date: 2018/11/20 下午4:24
 * @Description:
 */
@Slf4j
public class WeChatGroupUtils {

    private static final String ACCESS_TOKEN="?access_token=";

    /**
     * 获取分组下的人数
     * @param groupId
     * @param accessToken
     * @return
     */
    public static Integer getPepoleNumUnderGroup(Integer groupId ,String accessToken){
        Integer size =0;
        if(groupId !=null){
            HashMap<String, Object> map = new HashMap<>(4);
            map.put("tagid",groupId);
            map.put("next_openid","");
            String obj2json = null;
            try {
                obj2json = JSONUtils.obj2json(map);
            } catch (Exception e) {

            }
            String backJson = HttpClientUtils.doPostJson(WxApiUrlEnum.TAG_FANS.getValue() + ACCESS_TOKEN + accessToken, obj2json);
            try {
                Map<String, Object> stringObjectMap = JSONUtils.json2map(backJson);
                Map<String,List<String>> data = (Map<String, List<String>>) stringObjectMap.get("data");
                List<String> openIds = data.get("openid");
                size = openIds.size();
            } catch (Exception e) {
                log.error("getPeopelNumUnderGroup:jsonStr转换map失败！message:{}",e.getMessage());
            }
        }
        return size;
    }

    /**
     * 获取分组的详细信息
     * @param accessToken
     * @return
     */

    public static List<WeChatGroupDetailVO> getGroups(String accessToken){
        String backJson = HttpClientUtils.doGet(WxApiUrlEnum.TAG_GET.getValue() + ACCESS_TOKEN + accessToken);
        List<WeChatGroupDetailVO> weChatGroupDetailVOS = new ArrayList<>();

        Map<String, Object> stringObjectMap =new HashMap<>();
        try {
            stringObjectMap = JSONUtils.json2map(backJson);
        } catch (Exception e) {
            log.error("getGroups:jsonStr转换map失败！message:{}",e.getMessage());
        }
        List<Map<String,Object>> tags = (List<Map<String, Object>>) stringObjectMap.get("tags");
        tags.stream().forEach(item->{
            WeChatGroupDetailVO weChatGroupDetailVO = new WeChatGroupDetailVO();
            weChatGroupDetailVO.setGroupId((Integer) item.get("id"));
            weChatGroupDetailVO.setGroupName((String) item.get("name"));
            weChatGroupDetailVO.setCount((Integer) item.get("count"));
            weChatGroupDetailVOS.add(weChatGroupDetailVO);
        });

        return weChatGroupDetailVOS;
    }


    /**
     * 获取用户身上的标签列表
     * @param openId
     * @param accessToken
     * @return
     */
    public static List<Integer> getTagListByOpenId(String openId,String accessToken){
        Map<String, Object> stringObjectMap =new HashMap<>();
        stringObjectMap.put("openid",openId);
        String postJson = null;
        try {
            postJson = JSONUtils.obj2json(stringObjectMap);
        } catch (Exception e) {
            log.error("getTagListByOpenId:map转换jsonStr失败！message:{}",e.getMessage());
        }
        String backJson = HttpClientUtils.doPostJson(WxApiUrlEnum.TAG_ON_USER.getValue() + ACCESS_TOKEN + accessToken, postJson);
        Map<String, Object> map =new HashMap<>();
        try {
            map  = JSONUtils.json2map(backJson);
        } catch (Exception e) {
            log.error("getTagListByOpenId:jsonStr转换map失败！message:{}",e.getMessage());
        }
        List<Integer> tagList = (List<Integer>) map.get("tagid_list");
        return tagList;
    }


    /**
     * 批量给用户打标签
     * @param openId
     * @param tagId
     * @param accessToken
     */
    public static void bindTagToUsers(List<String> openId,Integer tagId,String accessToken){
        Map<String, Object> postMap = new HashMap<>();
        postMap.put("openid_list",openId);
        postMap.put("tagid",tagId);
        String postJson = null;
        try {
            postJson = JSONUtils.obj2json(postMap);
        } catch (Exception e) {
            log.error("bindTagToUsers:map转换jsonStr失败！message:{}",e.getMessage());
        }

        String backJson = HttpClientUtils.doPostJson(WxApiUrlEnum.TAG_ADD_ON_USERS.getValue() + ACCESS_TOKEN + accessToken, postJson);
        Map<String, Object> map =new HashMap<>();
        try {
            map  = JSONUtils.json2map(backJson);
        } catch (Exception e) {
            log.error("bindTagToUsers:jsonStr转换map失败！message:{}",e.getMessage());
        }
        Integer errcode = (Integer) map.get("errcode");
        String errmsg = (String) map.get("errmsg");
        if(errcode !=0){
            log.info("给用户打标签失败 errcode:{},errorMessage:{}",errcode,errmsg);
        }
    }

    /**
     * 批量给用户打取消标签
     * @param openId
     * @param tagId
     * @param accessToken
     */
    public static void cancelBindTagToUsers(List<String> openId,Integer tagId,String accessToken){
        Map<String, Object> postMap = new HashMap<>();
        postMap.put("openid_list",openId);
        postMap.put("tagid",tagId);
        String postJson = null;
        try {
            postJson = JSONUtils.obj2json(postMap);
        } catch (Exception e) {
            log.error("cancelBindTagToUsers:map转换jsonStr失败！message:{}",e.getMessage());
        }

        String backJson = HttpClientUtils.doPostJson(WxApiUrlEnum.TAG_DEL_ON_USERS.getValue() + ACCESS_TOKEN + accessToken, postJson);
        Map<String, Object> map =new HashMap<>();
        try {
            map  = JSONUtils.json2map(backJson);
        } catch (Exception e) {
            log.error("cancelBindTagToUsers:jsonStr转换map失败！message:{}",e.getMessage());
        }
        Integer errcode = (Integer) map.get("errcode");
        String errmsg = (String) map.get("errmsg");
        if(errcode !=0){
            log.info("批量给用户打取消标签 errcode:{},errorMessage:{}",errcode,errmsg);
        }
    }

    public static List<String> getPeopleOpenIdUnderTag(Integer tagId,String accessToken){
        List<String> finalOpenIds = new ArrayList<>();
        Map<String, Object> postJsonMap = new HashMap<>();
        postJsonMap.put("tagid",tagId);
        postJsonMap.put("next_openid","");
        Map<String, Object> map =new HashMap<>();
        for(int i= 0;i<=50;i++){
            String postJson = null;
            try {
                postJson = JSONUtils.obj2json(postJsonMap);
            } catch (Exception e) {
                log.error("getPeopleOpenIdUnderTag:map转换jsonStr失败！message:{}",e.getMessage());
            }
            String backJson = HttpClientUtils.doPostJson(WxApiUrlEnum.TAG_FANS.getValue() + ACCESS_TOKEN + accessToken, postJson);
            try {
                map  = JSONUtils.json2map(backJson);
            } catch (Exception e) {
                log.error("getTagListByOpenId:jsonStr转换map失败！message:{}",e.getMessage());
            }
            Integer count = (Integer) map.get("count");
            if(0==count){
                break;
            }
            String nextOpenid = (String) map.get("next_openid");
            Map<String,List<String>> data = (Map<String, List<String>>) map.get("data");
            List<String> openIds = data.get("openid");
            finalOpenIds.addAll(openIds);
            if(StringUtils.isEmpty(nextOpenid)){
                break;
            }
            postJsonMap.put("next_openid",nextOpenid);
        }
        return finalOpenIds;
    }

}
