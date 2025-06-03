package cn.mateogic.blog.web.service;

import cn.mateogic.blog.common.utils.Response;
import cn.mateogic.blog.web.model.vo.tag.FindTagArticlePageListReqVO;
import cn.mateogic.blog.web.model.vo.tag.FindTagListReqVO;

public interface TagService {
    /**
     * 获取标签列表
     * @return
     */
    Response findTagList(FindTagListReqVO findTagListReqVO);
    /**
     * 获取标签下文章分页列表
     * @param findTagArticlePageListReqVO
     * @return
     */
    Response findTagPageList(FindTagArticlePageListReqVO findTagArticlePageListReqVO);
}
