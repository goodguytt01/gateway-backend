package com.innnovation.emall.common.api;


import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseBo<T> implements Serializable {
    @JSONField(
            serialize = false
    )
    protected Class<T> clazz;
    protected String body;
    protected Long timeStamp;
    protected String sign;
    protected String token;
    protected String commandId;
    protected T params;

    public BaseBo() {
        for(Class clazz = this.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            Type t = clazz.getGenericSuperclass();
            if (t instanceof ParameterizedType) {
                Type[] args = ((ParameterizedType)t).getActualTypeArguments();
                if (args[0] instanceof Class) {
                    this.clazz = (Class)args[0];
                    break;
                }
            }
        }

    }

    public Class<T> getClazz() {
        return this.clazz;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCommandId() {
        return this.commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public T getParams() {
        return this.params;
    }

    public void setParams(T params) {
        this.params = params;
    }
}

