//package com.zx.background.controller;
//
//import java.util.List;
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.zx.background.model.UserModel;
//import com.zx.background.model.elasticsearch.News;
//import com.zx.background.service.NewsService;
//import com.zx.background.service.UserService;
//
///**
// * @author zhongxin
// * @date 2017年8月22日
// * @description news控制层
// */
//@RequestMapping("/newsController")
//@RestController
//public class NewsController {
//    
//    @Autowired
//    private NewsService newsService;
//    
//    /**
//     * @author zhongxin
//     * @date 2017年8月22日
//     * @description 初始化数据
//     */
//    @RequestMapping(value="/init",method=RequestMethod.POST)
//    public void init(){
//        newsService.init();
//    }
//    
//    /**
//     * @author zhongxin
//     * @date 2017年8月16日
//     * @description 用户详情
//     * @param userId
//     * @return
//     */
//    @RequestMapping(method = RequestMethod.GET)
//    public Iterable<News> findAll(){
//        AggregatedPageImpl<News> news = ( AggregatedPageImpl<News> ) newsService.findAll();
//       
//        return news.getContent();
//    }
//    
//    /**
//     * @author zhongxin
//     * @date 2017年8月16日
//     * @description 新增用户
//     * @param userModel
//     */
//    @RequestMapping(value="/{id}",method = RequestMethod.GET)
//    public News findById (@PathVariable String id){
//        return newsService.findById( id );
//    }
//    
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable String id){
//        newsService.deleteAll( id );
//    }
//    
//}
