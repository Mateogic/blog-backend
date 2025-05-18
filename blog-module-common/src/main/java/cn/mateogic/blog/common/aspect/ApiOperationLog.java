package cn.mateogic.blog.common.aspect;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)// 该注解在运行时可用，可通过反射在运行时被访问和解析
@Target(ElementType.METHOD)// 指定注解只能作用于方法上
@Documented// 表示该注解可以被javadoc工具提取
public @interface ApiOperationLog {

    /**
     * 日志注解
     * @return API功能描述
     */
    String description() default "";
}
