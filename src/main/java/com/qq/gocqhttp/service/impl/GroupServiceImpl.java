package com.qq.gocqhttp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qq.gocqhttp.service.GroupService;
import com.qq.gocqhttp.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GroupServiceImpl implements GroupService {
    @Value("${send.url}")
    private String url;
    Logger logger= LoggerFactory.getLogger(GroupServiceImpl.class);


    HttpUtil httpUtil=new HttpUtil();
    JSONObject jsonObj = new JSONObject();
    /**
     * 群聊消息主方法，用来处理逻辑
     * @param params 消息集合
     */
    @Override
    public void groupMain(Map<String,Object> params) {
        String message = (String) params.get("message");
        int group_id= (int) params.get("group_id");
        if ("菜单".equals(message)) {
            sendMsg(group_id);
        }

    }

    @Override
    public void sendMsg(int group_id) {
        String sendUrl = url+"/send_group_msg";
        String sendMessage="我是菜单啊哈哈哈哈哈哈哈哈哈哈";
        jsonObj.put("message", sendMessage);
        jsonObj.put("group_id", group_id);
        jsonObj.put("auto_escape", "false");
        String string = httpUtil.doPost(sendUrl, jsonObj.toString());
        JSONObject jsonObject = JSON.parseObject(string);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("status"));
        logger.info("发送成功啦："+ jsonObject);

    }





}
