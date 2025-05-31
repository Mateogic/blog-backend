package cn.mateogic.blog.web.service;

import cn.mateogic.blog.common.utils.Response;

public interface BlogSettingsService {
    /**
     * 获取博客设置信息
     * @return
     */
    Response findDetail();
}
