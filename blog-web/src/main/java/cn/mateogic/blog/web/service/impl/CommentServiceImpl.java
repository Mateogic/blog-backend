package cn.mateogic.blog.web.service.impl;

import cn.mateogic.blog.common.enums.ResponseCodeEnum;
import cn.mateogic.blog.common.exception.BizException;
import cn.mateogic.blog.common.utils.Response;
import cn.mateogic.blog.web.model.vo.comment.FindQQUserInfoReqVO;
import cn.mateogic.blog.web.model.vo.comment.FindQQUserInfoRspVO;
import cn.mateogic.blog.web.service.CommentService;
import cn.mateogic.blog.web.utils.StringUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api-key}")
    private String apiKey;

    @Override
    public Response findQQUserInfo(FindQQUserInfoReqVO findQQUserInfoReqVO) {
        String qq = findQQUserInfoReqVO.getQq();

        // 校验 QQ 号
        if (!StringUtil.isPureNumber(qq)) {
            log.warn("昵称输入的格式不是 QQ 号: {}", qq);
            throw new BizException(ResponseCodeEnum.NOT_QQ_NUMBER);
        }

        // 请求第三方接口
        String url = String.format("https://api.nsmao.net/api/qq/query?qq=%s&key=%s", qq, apiKey);
        String result = restTemplate.getForObject(url, String.class);

        log.info("通过 QQ 号获取用户信息: {}", result);

        // 解析响参
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> map = objectMapper.readValue(result, Map.class);
            if (Objects.equals(map.get("code"), HttpStatus.OK.value())) {

                // 获取响应参数中 data 节点下的数据
                Map<String, Object> data = (Map<String, Object>) map.get("data");

                if (!CollectionUtils.isEmpty(data)) {
                    // 获取用户头像、昵称、邮箱
                    return Response.success(FindQQUserInfoRspVO.builder()
                            .avatar(String.valueOf(data.get("avatar")))
                            .nickname(String.valueOf(data.get("nick")))
                            .mail(String.valueOf(data.get("email")))
                            .build());
                }
            }

            return Response.fail();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}