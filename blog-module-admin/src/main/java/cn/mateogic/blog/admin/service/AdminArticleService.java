package cn.mateogic.blog.admin.service;

import cn.mateogic.blog.admin.model.vo.article.DeleteArticleReqVO;
import cn.mateogic.blog.admin.model.vo.article.FindArticleDetailReqVO;
import cn.mateogic.blog.admin.model.vo.article.FindArticlePageListReqVO;
import cn.mateogic.blog.admin.model.vo.article.PublishArticleReqVO;
import cn.mateogic.blog.common.utils.Response;

public interface AdminArticleService {
    /**
     * 发布文章
     * @param publishArticleReqVO
     * @return
     */
    Response publishArticle(PublishArticleReqVO publishArticleReqVO);
    /**
     * 删除文章
     * @param deleteArticleReqVO
     * @return
     */
    Response deleteArticle(DeleteArticleReqVO deleteArticleReqVO);
    /**
     * 查询文章分页数据
     * @param findArticlePageListReqVO
     * @return
     */
    Response findArticlePageList(FindArticlePageListReqVO findArticlePageListReqVO);
    /**
     * 查询文章详情
     * @param findArticleDetailReqVO
     * @return
     */
    Response findArticleDetail(FindArticleDetailReqVO findArticleDetailReqVO);
}
