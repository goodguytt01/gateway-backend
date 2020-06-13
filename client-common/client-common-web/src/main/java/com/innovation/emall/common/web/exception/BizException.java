package com.innovation.emall.common.web.exception;


public class BizException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private boolean propertiesKey;

    public BizException(String message) {
        super(message);
        this.propertiesKey = true;
    }



    public BizException(String errorCode, String message) {
        this(errorCode, message, true);
    }

    public BizException(String errorCode, String message, Throwable cause) {
        this(errorCode, message, cause, true);
    }

    public BizException(int errorCode, String message) {
        super(message);
        this.propertiesKey = true;
        String strErrorCode = errorCode + "";
        this.setErrorCode(strErrorCode);
    }

    public BizException(String errorCode, String message, boolean propertiesKey) {
        super(message);
        this.propertiesKey = true;
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

    public BizException(String errorCode, String message, Throwable cause, boolean propertiesKey) {
        super(message, cause);
        this.propertiesKey = true;
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
        this.propertiesKey = true;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isPropertiesKey() {
        return this.propertiesKey;
    }

    public void setPropertiesKey(boolean propertiesKey) {
        this.propertiesKey = propertiesKey;
    }
}