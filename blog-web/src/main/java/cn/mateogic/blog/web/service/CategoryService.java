package cn.mateogic.blog.web.service;

import cn.mateogic.blog.common.utils.Response;
import cn.mateogic.blog.web.model.vo.category.FindCategoryArticlePageListReqVO;
import cn.mateogic.blog.web.model.vo.category.FindCategoryListReqVO;

public interface CategoryService {
    /**
     * 获取分类列表
     * @return
     */
    Response findCategoryList(FindCategoryListReqVO findCategoryListReqVO);
    /**
     * 获取分类下文章分页数据
     * @param findCategoryArticlePageListReqVO
     * @return
     */
    Response findCategoryArticlePageList(FindCategoryArticlePageListReqVO findCategoryArticlePageListReqVO);
}
