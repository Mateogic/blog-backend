package cn.mateogic.blog.web.service;

import cn.mateogic.blog.common.utils.Response;

public interface CategoryService {
    /**
     * 获取分类列表
     * @return
     */
    Response findCategoryList();
}
