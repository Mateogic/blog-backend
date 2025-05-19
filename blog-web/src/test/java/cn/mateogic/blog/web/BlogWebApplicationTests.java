package cn.mateogic.blog.web;

import cn.mateogic.blog.common.domain.dos.UserDO;
import cn.mateogic.blog.common.domain.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

// 日志注解以自动生成log对象
@Slf4j
@SpringBootTest
class BlogWebApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void testLog(){
        log.info("info级别日志");
        log.warn("warn级别日志");
        log.error("error级别日志");

        // 占位符测试
        String name = "mateogic";
        log.info("占位符日志测试，作者:{}", name);
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    void insertTest() {
        // 构建数据库实体类
        UserDO userDO = UserDO.builder()
                .username("mateogic")
                .password("Ljc13512881480!")
                .createTime(new Date())
                .updateTime(new Date())
                .isDeleted(false)
                .build();

        userMapper.insert(userDO);
    }
}
