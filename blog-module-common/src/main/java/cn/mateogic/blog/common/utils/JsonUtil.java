package cn.mateogic.blog.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// JSON工具类
public class JsonUtil {
    private static final ObjectMapper INSTANCE = new ObjectMapper();
    // 用于将传入的对象打印成 JSON 字符串
    public static String toJsonString(Object obj) {
        try {
            return INSTANCE.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return obj.toString();
        }
    }
}
