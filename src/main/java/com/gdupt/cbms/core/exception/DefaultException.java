package com.gdupt.cbms.core.exception;

/*
* @Name：DefaultException
* @Description:这是默认的异常类,定义为运行时异常
* @Date：2019
* */
public class DefaultException extends RuntimeException{

    public DefaultException() {
    }

    public DefaultException(String message) {
        super(message);
    }

    public DefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultException(Throwable cause) {
        super(cause);
    }

    public DefaultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
