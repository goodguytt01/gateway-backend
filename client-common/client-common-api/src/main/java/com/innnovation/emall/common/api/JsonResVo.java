package com.innnovation.emall.common.api;


import com.innnovation.emall.common.api.enums.ErrorEnum;

public class JsonResVo {
    private int code;
    private String errmsg;
    private Object data;

    public JsonResVo() {
    }

    public static JsonResVo buildSuccess() {
        return buildSuccess((Object)null);
    }

    public static JsonResVo buildSuccess(Object data) {
        return build(0, (String)null, data);
    }

    public static JsonResVo buildFail(ErrorEnum errorEnum) {
        return buildErrorResult(errorEnum.getErrorCode(), errorEnum.getErrorMessage());
    }

    public static JsonResVo buildErrorResult(int code, String errmsg) {
        return buildErrorResult(code, errmsg, (Object)null);
    }

    public static JsonResVo buildErrorResult(ErrorEnum errorEnum) {
        return buildErrorResult(errorEnum.getErrorCode(), errorEnum.getErrorMessage(), (Object)null);
    }

    public static JsonResVo buildErrorResult(int code, String errmsg, Object data) {
        return build(code, errmsg, data);
    }

    private static JsonResVo build(int code, String errmsg, Object data) {
        JsonResVo jsonResVo = new JsonResVo();
        jsonResVo.setCode(code);
        jsonResVo.setErrmsg(errmsg);
        jsonResVo.setData(data);
        return jsonResVo;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}