package cn.ph.blog.controller;

import cn.ph.blog.core.ret.RetResponse;
import cn.ph.blog.core.ret.RetResult;
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

    @PostMapping("/selectById")
    public RetResult<UserInfo> selectById(Integer id){
        UserInfo userInfo = userInfoService.selectById(id);
        System.out.println(userInfo);
        return RetResponse.makeOKRsp(userInfo);
    }
}
