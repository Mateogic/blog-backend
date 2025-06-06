package cn.mateogic.blog.web.controller;

import cn.mateogic.blog.common.aspect.ApiOperationLog;
import cn.mateogic.blog.common.utils.Response;
import cn.mateogic.blog.web.model.vo.tag.FindTagArticlePageListReqVO;
import cn.mateogic.blog.web.model.vo.tag.FindTagListReqVO;
import cn.mateogic.blog.web.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
@Api(tags = "标签")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/list")
    @ApiOperation(value = "前台获取标签列表")
    @ApiOperationLog(description = "前台获取标签列表")
    public Response findTagList(@RequestBody @Validated FindTagListReqVO findTagListReqVO) {
        return tagService.findTagList(findTagListReqVO);
    }
    @PostMapping("/article/list")
    @ApiOperation(value = "前台获取标签下文章列表")
    @ApiOperationLog(description = "前台获取标签下文章列表")
    public Response findTagPageList(@RequestBody @Validated FindTagArticlePageListReqVO findTagArticlePageListReqVO) {
        return tagService.findTagPageList(findTagArticlePageListReqVO);
    }
}
