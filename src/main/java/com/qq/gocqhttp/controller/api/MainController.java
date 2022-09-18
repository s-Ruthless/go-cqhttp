package com.qq.gocqhttp.controller.api;

import com.qq.gocqhttp.service.GroupService;
import com.qq.gocqhttp.service.PrivateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private PrivateService privateService;
    @Autowired
    private GroupService groupService;

     /**
     * 获取消息类型
     */
    @PostMapping("/main")
    public void selectById(@RequestBody Map<String, Object> params) {
        String post_type = (String) params.get("post_type");
        String message_type = (String) params.get("message_type");
        if (post_type.equals("message") && message_type.equals("group")) {
            groupService.groupMain(params);
        }
        if (post_type.equals("message") && message_type.equals("private")) {
            privateService.sendMsg("group_id");
        }
    }
}
