package com.innovation.emall.system.provider.mapper;

import com.innovation.emall.system.provider.entity.SecurityResource;
import com.innovation.emall.system.provider.entity.SecurityRole;

import java.util.List;

public interface SecurityRoleMapper {
    int insertSecurityRole(SecurityRole resource);
    SecurityRole getById(Long id);
    List<SecurityRole> searchList(SecurityRole role);
    int updateSecurityRole(SecurityRole resource);
    int updateDeleteStatus(SecurityRole resource);
}
