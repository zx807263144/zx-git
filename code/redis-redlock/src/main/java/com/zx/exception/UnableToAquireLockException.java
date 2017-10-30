package com.zx.exception;

/**
 * @author zhongxin
 * @date 2017年9月20日
 * @description 异常类
 */
public class UnableToAquireLockException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public UnableToAquireLockException(){
    }

    public UnableToAquireLockException(String message){
        super( message );
    }
    
    public UnableToAquireLockException(String message,Throwable cause){
        super( message, cause );
    }
}
