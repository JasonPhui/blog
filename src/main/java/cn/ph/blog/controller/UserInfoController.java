package cn.ph.blog.controller;

import cn.ph.blog.model.UserInfo;
import cn.ph.blog.sevice.UserInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;
    
    private String messages="hello git";
    
    @PostMapping("/hello")
    public String hello(){
        return "hello springboot";
    }

    @PostMapping("/selectById")
    public UserInfo selectById(Integer id){
        return userInfoService.selectById(id);
    }
}
