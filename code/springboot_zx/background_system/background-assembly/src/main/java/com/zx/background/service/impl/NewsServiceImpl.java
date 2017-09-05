//package com.zx.background.service.impl;
//
//import java.util.Date;
//import java.util.List;
//
//import org.elasticsearch.index.query.QueryBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.zx.background.dao.elasticsearch.ElasticsearchNewsDao;
//import com.zx.background.model.elasticsearch.News;
//import com.zx.background.service.NewsService;
//
///**
// * @author zhongxin
// * @date 2017年8月22日
// * @description service实现类
// */
//@Service
//public class NewsServiceImpl implements NewsService {
//    
//    @Autowired
//    private ElasticsearchNewsDao elasticsearchNewsDao;
//
//    @Override
//    public Iterable<News> findAll() {
//        return elasticsearchNewsDao.findAll();
//    }
//
//    @Override
//    public Iterable<News> search( QueryBuilder queryBuilder ) {
//        return elasticsearchNewsDao.search( queryBuilder );
//    }
//
//    @Override
//    public News findById( String id ) {
//        return elasticsearchNewsDao.findOne( id );
//    }
//
//    @Override
//    public void deleteAll( String id ) {
//        elasticsearchNewsDao.delete( id );
//    }
//    
//    public void init(){
//        for (int i = 1; i < 100; i++){
//            News news = new News();
//            news.setId(  i + "" );
//            news.setTitle( "钟鑫测试elasticsearch" + i );
//            news.setContent( "钟鑫测试elasticsearch" + i + "xxxxxx" );
//            news.setCreateTime( new Date() );
//            elasticsearchNewsDao.save( news );
//        }
//    }
//
//}
