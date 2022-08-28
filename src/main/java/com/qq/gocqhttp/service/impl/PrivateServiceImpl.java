package com.qq.gocqhttp.service.impl;

import com.qq.gocqhttp.service.PrivateService;
import com.qq.gocqhttp.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PrivateServiceImpl implements PrivateService {
    @Value("${send.url}")
    private String url;
    @Override
    public void sendMsg(String user_id) {
        HttpUtil httpUtil=new HttpUtil();
        httpUtil.doGet(url);
        System.out.println(user_id);
    }
}
