package com.zx.maybatis.generator.comment;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * @author zhongxin
 * @date 2017年8月15日
 * @description 生成字段注释
 */
public class SimpleCommentGenerator extends DefaultCommentGenerator{
    
    @Override
    public void addFieldComment( Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn ) {
        String comment = null;
        if (null != introspectedColumn){
            comment = introspectedColumn.getRemarks();
        }
        
        if (comment != null && !"".equals( comment.trim() )){
            comment = comment.trim();
            field.addJavaDocLine( "/**" );
            field.addJavaDocLine( " * " + comment + "." );
            field.addJavaDocLine(  " */" );
        }
    }
    
    @Override
    public void addFieldComment( Field field, IntrospectedTable introspectedTable ) {
        addFieldComment( field, introspectedTable,null );
    }
}
