package com.innovation.gateway.system.provider.mapper;

import com.innovation.gateway.system.provider.entity.SecurityResource;

import java.util.List;

public interface SecurityResourceMapper {
    int insertSecurityResource(SecurityResource resource);
    SecurityResource getById(Long id);
    int updateSecurityResource(SecurityResource resource);
    int updateDeleteStatus(SecurityResource  resource);
    List<SecurityResource> searchList(SecurityResource resource);

}
