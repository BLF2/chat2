package com.wlld.myjecs.controller;

import com.wlld.myjecs.bean.LoginReq;
import com.wlld.myjecs.business.AdminBusiness;
import com.wlld.myjecs.entity.Admin;
import com.wlld.myjecs.entity.mes.AdminSentence;
import com.wlld.myjecs.entity.mes.Response;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Resource
    private AdminBusiness adminBusiness;

    @PostMapping("/login")
    public Response<Admin> login(@RequestBody LoginReq loginReq){
        //校验数据
        if(!StringUtils.hasText(loginReq.getUsername()) || !StringUtils.hasText(loginReq.getUsername())) {
            return Response.fail(1,"用户名密码不正确",null);
        }
        return adminBusiness.chatLogin(loginReq.getUsername(), loginReq.getPassword());
    }
}
