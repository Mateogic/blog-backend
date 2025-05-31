package cn.mateogic.blog.web.service;

import cn.mateogic.blog.common.utils.Response;

public interface TagService {
    /**
     * 获取标签列表
     * @return
     */
    Response findTagList();
}
