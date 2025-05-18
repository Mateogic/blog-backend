package cn.mateogic.blog.web.controller;

import cn.mateogic.blog.web.model.User;
import cn.mateogic.blog.common.aspect.ApiOperationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 测试日志注解
@RestController
@Slf4j
public class TestController {
    @PostMapping("/test")
    @ApiOperationLog(description = "测试日志注解")
    public User test(@RequestBody User user) {
        return user;
    }
}
