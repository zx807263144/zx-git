package com.zx.background.model.elasticsearch;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * @author zhongxin
 * @date 2017年8月22日
 * @description elasticsearch中使用的model
 * indexName相当于数据库名
 * type相当于table
 */
//@Document(indexName="springboot_elasticsearch",type="news")
public class News {
    
    /**
     * id
     */
//    @Id
    private String id;
    
    /**
     * 标题
     */
    private String title;
    
    /**
     * 内容
     */
    private String content;
    
    /**
     * 创建时间
     */
    @JsonFormat(shape=Shape.STRING,pattern="yyyyMMdd'T'HHmmss.SSS'Z'")
//    @Field(type=FieldType.Date,format=DateFormat.basic_date_time,index=FieldIndex.not_analyzed)
//    @CreatedDate
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent( String content ) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime( Date createTime ) {
        this.createTime = createTime;
    }
}
