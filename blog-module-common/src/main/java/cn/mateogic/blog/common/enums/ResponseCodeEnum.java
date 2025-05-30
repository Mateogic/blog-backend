package cn.mateogic.blog.common.enums;

import cn.mateogic.blog.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {
    // ----------- 通用异常状态码 -----------
    SYSTEM_ERROR("10000", "出错啦，后台小哥正在努力修复中..."),

    // ----------- 业务异常状态码 -----------
    PRODUCT_NOT_FOUND("20000", "该产品不存在（测试使用）"),

    PARAM_NOT_VALID("10001", "参数错误"),
    // ----------- 登录失败响应码 -----------
    LOGIN_FAIL("20000", "登录失败"),
    USERNAME_OR_PWD_ERROR("20001", "用户名或密码错误"),
    // ----------- 无访问权限响应码 -----------
    UNAUTHORIZED("20002", "无访问权限，请先登录！"),
    // ----------- 用户不存在响应码 -----------
    USERNAME_NOT_FOUND("20003", "该用户不存在"),
    // ----------- 访问受限响应码 -----------
    FORBIDDEN("20004", "演示账号仅支持查询操作！"),
    // ----------- 分类相关异常状态码 -----------
    CATEGORY_NAME_IS_EXISTED("20005", "该分类已存在，请勿重复添加！"),
    // ----------- 标签相关异常状态码 -----------
    TAG_CANT_DUPLICATE("20006", "该标签已存在，请勿重复添加！"),
    TAG_NOT_EXISTED("20007", "该标签不存在，请检查后重试！")
    ;

    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;
}
