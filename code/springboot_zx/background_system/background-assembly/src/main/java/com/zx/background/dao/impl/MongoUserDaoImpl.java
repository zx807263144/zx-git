//package com.zx.background.dao.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.stereotype.Repository;
//
//import com.zx.background.dao.MongoUserDao;
//import com.zx.background.model.UserModel;
//
///**
// * @author zhongxin
// * @date 2017年8月21日
// * @description UserModel对应的mongodb的dao实现
// */
//@Repository
//public class MongoUserDaoImpl implements MongoUserDao {
//    
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Override
//    public void delete( Long id ) {
//        Query query = new Query();
//        query.addCriteria( Criteria.byExample( "_id" ).is( id ) );
//        mongoTemplate.remove( query, UserModel.class );
//    }
//
//    @Override
//    public void create( UserModel record ) {
//        mongoTemplate.insert( record );
//    }
//
//    @Override
//    public UserModel find( Long id ) {
//        return mongoTemplate.findById( id, UserModel.class );
//    }
//
//    @Override
//    public void update( UserModel record ) {
//        mongoTemplate.save( record );
//    }
//
//    @Override
//    public List<UserModel> findUserList() {
//        return mongoTemplate.findAll( UserModel.class );
//    }
//
//}
