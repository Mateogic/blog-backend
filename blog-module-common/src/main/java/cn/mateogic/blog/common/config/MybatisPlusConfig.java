package cn.mateogic.blog.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.mateogic.blog.common.domain.mapper")
public class MybatisPlusConfig {
}