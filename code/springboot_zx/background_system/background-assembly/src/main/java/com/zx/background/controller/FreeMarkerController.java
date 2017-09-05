package com.zx.background.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

/**
 * @author zhongxin
 * @date 2017年8月29日
 * @description 测试freemarker模板
 */
@Controller
@RequestMapping("/freeMarkerController")
public class FreeMarkerController {
    
    @Autowired
    private Configuration configuration;
    
    @RequestMapping("/welcome")
    public String welcome(Map<String,Object> model){
        model.put( "time", new Date() );
        model.put( "message", "你好，钟鑫" );
        return "welcome";
    }
    
    /**
     * @author zhongxin
     * @date 2017年8月29日
     * @description 把相对不会变化的内容通过 FreeMarker 渲染生成静态文件上传到内容服务，内容服务通过 CDN 进行资源分发
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/welcome2")
    public String welcome2(Map<String,Object> model) throws Exception{
        model.put( "time", new Date() );
        model.put( "message", "你好，钟鑫" );
        
        Template template = configuration.getTemplate( "welcome.ftl" );
        String content = FreeMarkerTemplateUtils.processTemplateIntoString( template, model );
        FileUtils.writeStringToFile( new File("D:/welcome.html"), content );
        
        return "welcome";
    }
}
