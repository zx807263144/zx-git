package com.zx.background.service;

import com.zx.background.model.elasticsearch.News;

/**
 * @author zhongxin
 * @date 2017年8月22日
 * @description elasticsearch的news
 */
public interface NewsService {
    /**
     * @author zhongxin
     * @date 2017年8月22日
     * @description 查询全部news
     * @return
     */
    Iterable<News> findAll();
    
    /**
     * @author zhongxin
     * @date 2017年8月22日
     * @description 根据条件查询news
     * @param queryBuilder
     * @return
     */
//    Iterable<News> search(QueryBuilder queryBuilder);
    
    /**
     * @author zhongxin
     * @date 2017年8月22日
     * @description 根据id查询news
     * @param title
     * @return
     */
    News findById(String id);
    
    /**
     * @author zhongxin
     * @date 2017年8月22日
     * @description 根据id删除全部news
     * @param id
     */
    void deleteAll(String id);
    
    /**
     * @author zhongxin
     * @date 2017年8月22日
     * @description 初始化数据
     */
    void init();
}
