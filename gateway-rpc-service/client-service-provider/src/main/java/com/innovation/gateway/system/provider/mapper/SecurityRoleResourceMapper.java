package com.innovation.gateway.system.provider.mapper;

import com.innovation.gateway.system.provider.entity.SecurityRoleResource;

import java.util.List;

public interface SecurityRoleResourceMapper {
    int insertSecurityRoleResource(SecurityRoleResource resource);
    SecurityRoleResource getById(Long id);
    List<SecurityRoleResource> searchList(SecurityRoleResource RoleResource);
    int updateSecurityRoleResource(SecurityRoleResource resource);
    int updateDeleteStatus(SecurityRoleResource resource);
}
