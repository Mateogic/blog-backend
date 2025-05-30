package cn.mateogic.blog.admin.service;

import cn.mateogic.blog.admin.model.vo.article.PublishArticleReqVO;
import cn.mateogic.blog.common.utils.Response;

public interface AdminArticleService {
    /**
     * 发布文章
     * @param publishArticleReqVO
     * @return
     */
    Response publishArticle(PublishArticleReqVO publishArticleReqVO);
}
