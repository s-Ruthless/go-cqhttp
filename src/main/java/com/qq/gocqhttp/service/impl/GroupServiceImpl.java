package com.qq.gocqhttp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qq.gocqhttp.service.GroupService;
import com.qq.gocqhttp.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Value("${send.url}")
    private String url;

    @Override
    public void sendMsg(int group_id,String message) {
        HttpUtil httpUtil=new HttpUtil();
        JSONObject param = new JSONObject();
        String sendurl = url+"/send_group_msg";
        String sendMessage="我是菜单啊哈哈哈哈哈哈哈哈哈哈";
        param.put("group_id", group_id);
        param.put("message", sendMessage);
        param.put("auto_escape", "false");
       // System.out.println(param);
        if(message.equals("菜单")){
            httpUtil.doPost(sendurl,param.toString());
        }

    }
}
