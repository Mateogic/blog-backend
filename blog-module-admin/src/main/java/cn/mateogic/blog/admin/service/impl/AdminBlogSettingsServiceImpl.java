package cn.mateogic.blog.admin.service.impl;

import cn.mateogic.blog.admin.convert.BlogSettingsConvert;
import cn.mateogic.blog.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import cn.mateogic.blog.admin.service.AdminBlogSettingsService;
import cn.mateogic.blog.common.domain.dos.BlogSettingsDO;
import cn.mateogic.blog.common.domain.mapper.BlogSettingsMapper;
import cn.mateogic.blog.common.utils.Response;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdminBlogSettingsServiceImpl extends ServiceImpl<BlogSettingsMapper, BlogSettingsDO> implements AdminBlogSettingsService {

    @Override
    public Response updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO) {
        // VO 转 DO
        BlogSettingsDO blogSettingsDO = BlogSettingsConvert.INSTANCE.convertVO2DO(updateBlogSettingsReqVO);
        blogSettingsDO.setId(1L);

        // 保存或更新（当数据库中存在 ID 为 1 的记录时，则执行更新操作，否则执行插入操作）
        saveOrUpdate(blogSettingsDO);
        return Response.success();
    }
}

