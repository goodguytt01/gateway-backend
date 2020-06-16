package com.innovation.gateway.system.provider.mapper;

import com.innovation.gateway.system.provider.entity.SecurityRole;

import java.util.List;

public interface SecurityRoleMapper {
    int insertSecurityRole(SecurityRole resource);
    SecurityRole getById(Long id);
    List<SecurityRole> searchList(SecurityRole role);
    int updateSecurityRole(SecurityRole resource);
    int updateDeleteStatus(SecurityRole resource);
}
