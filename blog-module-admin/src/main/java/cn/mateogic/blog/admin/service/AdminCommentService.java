package cn.mateogic.blog.admin.service;

import cn.mateogic.blog.admin.model.vo.comment.DeleteCommentReqVO;
import cn.mateogic.blog.admin.model.vo.comment.ExamineCommentReqVO;
import cn.mateogic.blog.admin.model.vo.comment.FindCommentPageListReqVO;
import cn.mateogic.blog.common.utils.Response;

public interface AdminCommentService {

    /**
     * 查询评论分页数据
     * @param findCommentPageListReqVO
     * @return
     */
    Response findCommentPageList(FindCommentPageListReqVO findCommentPageListReqVO);
    /**
     * 删除评论
     * @param deleteCommentReqVO
     * @return
     */
    Response deleteComment(DeleteCommentReqVO deleteCommentReqVO);
    /**
     * 评论审核
     * @param examineCommentReqVO
     * @return
     */
    Response examine(ExamineCommentReqVO examineCommentReqVO);
}
