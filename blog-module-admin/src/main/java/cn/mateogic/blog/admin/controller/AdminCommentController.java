package cn.mateogic.blog.admin.controller;

import cn.mateogic.blog.admin.model.vo.comment.DeleteCommentReqVO;
import cn.mateogic.blog.admin.model.vo.comment.FindCommentPageListReqVO;
import cn.mateogic.blog.admin.service.AdminCommentService;
import cn.mateogic.blog.common.aspect.ApiOperationLog;
import cn.mateogic.blog.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/comment")
@Api(tags = "Admin 评论模块")
public class AdminCommentController {

    @Autowired
    private AdminCommentService commentService;

    @PostMapping("/list")
    @ApiOperation(value = "查询评论分页数据")
    @ApiOperationLog(description = "查询评论分页数据")
    public Response findCommentPageList(@RequestBody @Validated FindCommentPageListReqVO findCommentPageListReqVO) {
        return commentService.findCommentPageList(findCommentPageListReqVO);
    }
    @PostMapping("/delete")
    @ApiOperation(value = "评论删除")
    @ApiOperationLog(description = "评论删除")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response deleteComment(@RequestBody @Validated DeleteCommentReqVO deleteCommentReqVO) {
        return commentService.deleteComment(deleteCommentReqVO);
    }
}