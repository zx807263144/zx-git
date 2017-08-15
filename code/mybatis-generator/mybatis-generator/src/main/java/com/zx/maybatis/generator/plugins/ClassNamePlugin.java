package com.zx.maybatis.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

/**
 * @author zhongxin
 * @date 2017年8月15日
 * @description 文件名称
 */
public class ClassNamePlugin extends PluginAdapter {
    
    @Override
    public boolean validate( List<String> arg0 ) {
        return true;
    }

    @Override
    public void initialized( IntrospectedTable introspectedTable ) {
        String newType = introspectedTable.getBaseRecordType()+"Model";
        String newMapper = introspectedTable.getMyBatis3JavaMapperType().replaceAll( "Mapper$", "Dao" );
        
        introspectedTable.setBaseRecordType( newType );
        introspectedTable.setExampleType( newType + "Example" );
        introspectedTable.setMyBatis3JavaMapperType( newMapper );
    }
}
