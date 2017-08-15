package com.zx.background.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhongxin
 * @date 2017年8月15日
 * @description 所有model的基model
 */
public class BaseModel implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    
    /**
     *创建时间
     */
    private Date gmtCreateTime;
    
    /**
     * 修改时间
     */
    private Date gmtModifyTime;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Date getGmtCreateTime() {
        return gmtCreateTime;
    }

    public void setGmtCreateTime( Date gmtCreateTime ) {
        this.gmtCreateTime = gmtCreateTime;
    }

    public Date getGmtModifyTime() {
        return gmtModifyTime;
    }

    public void setGmtModifyTime( Date gmtModifyTime ) {
        this.gmtModifyTime = gmtModifyTime;
    }
}
