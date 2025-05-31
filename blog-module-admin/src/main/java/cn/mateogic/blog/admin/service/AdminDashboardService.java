package cn.mateogic.blog.admin.service;

import cn.mateogic.blog.common.utils.Response;

public interface AdminDashboardService {

    /**
     * 获取仪表盘基础统计信息
     * @return
     */
    Response findDashboardStatistics();
}
