package cn.mateogic.blog.admin.service;

import cn.mateogic.blog.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import cn.mateogic.blog.common.utils.Response;

public interface AdminBlogSettingsService {
    /**
     * 更新博客设置信息
     * @param updateBlogSettingsReqVO
     * @return
     */
    Response updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO);
}
