package cn.mateogic.blog.admin.service;

import cn.mateogic.blog.admin.model.vo.tag.AddTagReqVO;
import cn.mateogic.blog.admin.model.vo.tag.FindTagPageListReqVO;
import cn.mateogic.blog.common.utils.PageResponse;
import cn.mateogic.blog.common.utils.Response;

public interface AdminTagService {

    // 添加标签集合
    Response addTags(AddTagReqVO addTagReqVO);
    // 分页查询标签集合
    PageResponse findTagPageList(FindTagPageListReqVO findTagPageListReqVO);
}