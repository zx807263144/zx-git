package com.zx.maybatis.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

/**
 * @author zhongxin
 * @date 2017年8月15日
 * @description 初始化方法名称插件
 */
public class InitMethodNamePlugin extends PluginAdapter {

    @Override
    public boolean validate( List<String> arg0 ) {
        return true;
    }
    
    @Override
    public void initialized( IntrospectedTable introspectedTable ) {
        changeMethodName(introspectedTable);
    }

    /**
     * @author zhongxin
     * @date 2017年8月15日
     * @description 改变mybatis-generator默认生成的方法名
     * @param introspectedTable
     */
    private void changeMethodName( IntrospectedTable introspectedTable ) {
        introspectedTable.setSelectByPrimaryKeyStatementId( "find" );
        introspectedTable.setInsertStatementId( "create" );
        introspectedTable.setUpdateByPrimaryKeyStatementId( "update" );
        
        introspectedTable.setBaseResultMapId( "Result" );
        introspectedTable.setBaseColumnListId( "Columns" );
        introspectedTable.setUpdateByPrimaryKeySelectiveStatementId( "updateProperties" );
        introspectedTable.setDeleteByPrimaryKeyStatementId( "delete" );
    }

}
