package com.innovation.emall.system.api.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientDTO implements Serializable {

    private Long clientId;

    private String mobile;

    private String password;

    private String validCode;

    private String channel;

    private int loginType;
}
