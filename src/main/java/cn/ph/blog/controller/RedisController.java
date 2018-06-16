package cn.ph.blog.controller;

import cn.ph.blog.core.ret.RetResponse;
import cn.ph.blog.core.ret.RetResult;
import cn.ph.blog.service.RedisService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Resource
    RedisService redisService;

    @PostMapping("/setRedis")
    public RetResult<String> setRedis(String name){
        redisService.set("name", name);
        return RetResponse.makeOKRsp(name);
    }

    @PostMapping("/getRedis")
    public RetResult<String> getRedis() {
        String name = redisService.get("name");
        return RetResponse.makeOKRsp(name);
    }
}
