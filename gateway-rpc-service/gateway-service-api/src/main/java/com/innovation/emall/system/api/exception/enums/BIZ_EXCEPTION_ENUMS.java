package com.innovation.emall.system.api.exception.enums;

import lombok.Data;

public enum  BIZ_EXCEPTION_ENUMS {
    EMPETY_PARAMETER_EXCEPTION(9001,"传入参数为空"),  WRONG_PASS(1004,"密码错误，请重新输入"),SYSTEM_ERROR(9999,"系统内部错误"),  VALID_CODE_ERROR(1002,"验证码错误，请重新输入"),  SEMD_VALID_CODE_BEFORE_LOGIN(1001,"登录前请先发送验证码"),  USER_NOT_EXIST_ERROR_STATUS(1003,"用户不存在或异常状态");

    private final String msg;

    private final int code;

    private BIZ_EXCEPTION_ENUMS(int code,String msg) {
        this.msg = msg;

        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
