package com.innovation.emall.system.provider.mapper;

import com.innovation.emall.system.provider.entity.SecurityRoleResource;

import java.util.List;

public interface SecurityRoleResourceMapper {
    int insertSecurityRoleResource(SecurityRoleResource resource);
    SecurityRoleResource getById(Long id);
    List<SecurityRoleResource> searchList(SecurityRoleResource RoleResource);
    int updateSecurityRoleResource(SecurityRoleResource resource);
    int updateDeleteStatus(SecurityRoleResource resource);
}
