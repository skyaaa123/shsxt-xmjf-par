package com.shsxt.xmjf.web.controller;

import com.shsxt.xmjf.api.model.User;
import com.shsxt.xmjf.api.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lp on 2018/5/11.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private IUserService userService;


    @RequestMapping("queryUserByUserId")
    @ResponseBody
    public User  queryUserById(Integer userId){
        return userService.queryUserByUserId(userId);
    }
}
