package com.innovation.emall.system.provider.mapper;

import com.innovation.emall.system.provider.entity.SecurityResource;
import com.innovation.emall.system.provider.entity.SecurityRole;

import java.util.List;

public interface SecurityResourceMapper {
    int insertSecurityResource(SecurityResource resource);
    SecurityResource getById(Long id);
    int updateSecurityResource(SecurityResource resource);
    int updateDeleteStatus(SecurityResource  resource);
    List<SecurityResource> searchList(SecurityResource resource);

}
