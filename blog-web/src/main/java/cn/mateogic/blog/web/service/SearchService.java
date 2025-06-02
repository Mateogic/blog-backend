package cn.mateogic.blog.web.service;

import cn.mateogic.blog.common.utils.Response;
import cn.mateogic.blog.web.model.vo.search.SearchArticlePageListReqVO;

public interface SearchService {

    /**
     * 关键词分页搜索
     * @param searchArticlePageListReqVO
     * @return
     */
    Response searchArticlePageList(SearchArticlePageListReqVO searchArticlePageListReqVO);
}
