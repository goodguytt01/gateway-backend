package com.innnovation.emall.common.api.enums;


public enum ErrorEnum  {
    SYSTEM_ERROR(10000, 10000, "系统错误"),
    REQUEST_INVALID(11000, 11000, "无效请求"),
    ERROR_BIZ_FAIL(20000, 20001, "业务失败"),
    ERROR_WRITE(500, 501, "渲染界面错误"),
    ERROR_PARAM(12000, 12002, "参数校验错误"),
    ERROR_PARAM_FORMAT(12000, 12003, "参数类型错误"),
    ERROR_TOKEN_VALID(14000, 14001, "Token过期"),
    ERROR_TOKEN_CHECK(14000, 14002, "Token验证异常"),
    ERROR_ADMIN_RIGHT(14000, 14003, "权限不足"),
    ERROR_ADMIN_RIGHT_NULL(14000, 14004, "权限不为空");

    private final int errorCode;
    private final int parentCode;
    private final String errorMessage;

    private ErrorEnum(int parentCode, int errorCode, String errorMessage) {
        this.parentCode = parentCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getParentCode() {
        return String.valueOf(this.errorCode).startsWith("1") ? this.errorCode : this.parentCode;
    }

    public ErrorEnum getOutError() {
        return getErrorByCode(this.getParentCode());
    }

    public static ErrorEnum getErrorByCode(int code) {
        ErrorEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ErrorEnum errorEnum = var1[var3];
            if (errorEnum.getErrorCode() == code) {
                return errorEnum;
            }
        }

        return null;
    }
}

