package cn.mateogic.blog.admin.service;

import cn.mateogic.blog.admin.model.vo.tag.AddTagReqVO;
import cn.mateogic.blog.common.utils.Response;

public interface AdminTagService {

    Response addTags(AddTagReqVO addTagReqVO);
}