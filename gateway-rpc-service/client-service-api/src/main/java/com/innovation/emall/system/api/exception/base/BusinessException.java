package com.innovation.emall.system.api.exception.base;

import com.innovation.emall.system.api.exception.enums.BIZ_EXCEPTION_ENUMS;

/**
 * 业务异常.
 *
 * @author zhangxd
 */
public class BusinessException extends Exception {

    private int code;

    private String msg;

    public BusinessException() {
        super();
    }
    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BusinessException(int code ,String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public BusinessException(BIZ_EXCEPTION_ENUMS exceptionEnums) {
        super(exceptionEnums.getMsg());
        this.code = exceptionEnums.getCode();
        this.msg = exceptionEnums.getMsg();
    }

}