package cn.mateogic.blog.admin.service;

import cn.mateogic.blog.admin.model.vo.tag.AddTagReqVO;
import cn.mateogic.blog.admin.model.vo.tag.DeleteTagReqVO;
import cn.mateogic.blog.admin.model.vo.tag.FindTagPageListReqVO;
import cn.mateogic.blog.admin.model.vo.tag.SearchTagsReqVO;
import cn.mateogic.blog.common.utils.PageResponse;
import cn.mateogic.blog.common.utils.Response;

public interface AdminTagService {

    // 添加标签集合
    Response addTags(AddTagReqVO addTagReqVO);
    // 分页查询标签集合
    PageResponse findTagPageList(FindTagPageListReqVO findTagPageListReqVO);

    Response deleteTag(DeleteTagReqVO deleteTagReqVO);
    /**
     * 根据标签关键词模糊查询
     * @param searchTagsReqVO
     * @return
     */
    Response searchTags(SearchTagsReqVO searchTagsReqVO);
    /**
     * 查询标签 Select 列表数据
     * @return
     */
    Response findTagSelectList();

}