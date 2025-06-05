package cn.mateogic.blog.admin.service;

import cn.mateogic.blog.admin.model.vo.wiki.AddWikiReqVO;
import cn.mateogic.blog.admin.model.vo.wiki.DeleteWikiReqVO;
import cn.mateogic.blog.admin.model.vo.wiki.FindWikiPageListReqVO;
import cn.mateogic.blog.common.utils.Response;

public interface AdminWikiService {

    /**
     * 新增知识库
     * @param addWikiReqVO
     * @return
     */
    Response addWiki(AddWikiReqVO addWikiReqVO);
    /**
     * 删除知识库
     * @param deleteWikiReqVO
     * @return
     */
    Response deleteWiki(DeleteWikiReqVO deleteWikiReqVO);
    /**
     * 知识库分页查询
     * @param findWikiPageListReqVO
     * @return
     */
    Response findWikiPageList(FindWikiPageListReqVO findWikiPageListReqVO);
}
