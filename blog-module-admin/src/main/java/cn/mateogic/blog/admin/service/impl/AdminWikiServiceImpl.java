package cn.mateogic.blog.admin.service.impl;

import cn.mateogic.blog.admin.model.vo.wiki.AddWikiReqVO;
import cn.mateogic.blog.admin.model.vo.wiki.DeleteWikiReqVO;
import cn.mateogic.blog.admin.service.AdminWikiService;
import cn.mateogic.blog.common.domain.dos.ArticleDO;
import cn.mateogic.blog.common.domain.dos.WikiCatalogDO;
import cn.mateogic.blog.common.domain.dos.WikiDO;
import cn.mateogic.blog.common.domain.mapper.ArticleMapper;
import cn.mateogic.blog.common.domain.mapper.WikiCatalogMapper;
import cn.mateogic.blog.common.domain.mapper.WikiMapper;
import cn.mateogic.blog.common.enums.ArticleTypeEnum;
import cn.mateogic.blog.common.enums.ResponseCodeEnum;
import cn.mateogic.blog.common.enums.WikiCatalogLevelEnum;
import cn.mateogic.blog.common.exception.BizException;
import cn.mateogic.blog.common.utils.Response;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AdminWikiServiceImpl implements AdminWikiService {

    @Autowired
    private WikiMapper wikiMapper;
    @Autowired
    private WikiCatalogMapper wikiCatalogMapper;
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 新增知识库
     *
     * @param addWikiReqVO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response addWiki(AddWikiReqVO addWikiReqVO) {
        // VO 转 DO
        WikiDO wikiDO = WikiDO.builder()
                .cover(addWikiReqVO.getCover())
                .title(addWikiReqVO.getTitle())
                .summary(addWikiReqVO.getSummary())
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        // 新增知识库
        wikiMapper.insert(wikiDO);
        // 获取新增记录的主键 ID
        Long wikiId = wikiDO.getId();

        // 初始化默认目录
        // > 概述
        // > 基础
        wikiCatalogMapper.insert(WikiCatalogDO.builder().wikiId(wikiId).title("概述").sort(1).build());
        wikiCatalogMapper.insert(WikiCatalogDO.builder().wikiId(wikiId).title("基础").sort(2).build());
        return Response.success();
    }
    /**
     * 删除知识库
     *
     * @param deleteWikiReqVO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Response deleteWiki(DeleteWikiReqVO deleteWikiReqVO) {
        Long wikiId = deleteWikiReqVO.getId();

        // 删除知识库
        int count = wikiMapper.deleteById(wikiId);

        // 若知识库不存在
        if (count == 0) {
            log.warn("该知识库不存在, wikiId: {}", wikiId);
            throw new BizException(ResponseCodeEnum.WIKI_NOT_FOUND);
        }

        // 查询此知识库下所有目录
        List<WikiCatalogDO> wikiCatalogDOS = wikiCatalogMapper.selectByWikiId(wikiId);
        // 过滤目录中所有文章的 ID
        List<Long> articleIds = wikiCatalogDOS.stream()
                .filter(wikiCatalogDO -> Objects.nonNull(wikiCatalogDO.getArticleId())  // 文章 ID 不为空
                        && Objects.equals(wikiCatalogDO.getLevel(), WikiCatalogLevelEnum.TWO.getValue())) // 二级目录
                .map(WikiCatalogDO::getArticleId) // 提取文章 ID
                .collect(Collectors.toList());

        // 更新文章类型 type 为普通
        if (!CollectionUtils.isEmpty(articleIds)) {
            articleMapper.updateByIds(ArticleDO.builder()
                    .type(ArticleTypeEnum.NORMAL.getValue())
                    .build(), articleIds);
        }

        // 删除知识库目录
        wikiCatalogMapper.deleteByWikiId(wikiId);
        return Response.success();
    }

}