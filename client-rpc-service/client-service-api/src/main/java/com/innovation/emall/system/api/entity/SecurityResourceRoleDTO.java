package com.innovation.emall.system.api.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SecurityResourceRoleDTO extends BaseDTO implements Serializable{

    private Long roleId;

    private Long resource;

}
