package com.qq.gocqhttp.service;

import java.util.Map;

public interface GroupService {
    /**
     * 群聊功能主方法
     * @param params 消息集合
     */
    void groupMain(Map<String,Object> params);

    /**
     * 发送群消息
     * @param group_id 群号
     */
    void sendMsg(int group_id);
}
