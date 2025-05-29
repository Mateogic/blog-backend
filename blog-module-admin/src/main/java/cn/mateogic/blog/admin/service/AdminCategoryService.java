package cn.mateogic.blog.admin.service;

import cn.mateogic.blog.admin.model.vo.category.AddCategoryReqVO;
import cn.mateogic.blog.common.utils.Response;

public interface AdminCategoryService {
    /**
     * 添加分类
     * @param addCategoryReqVO
     * @return
     */
    Response addCategory(AddCategoryReqVO addCategoryReqVO);
}