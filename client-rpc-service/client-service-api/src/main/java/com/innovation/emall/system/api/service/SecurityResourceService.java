package com.innovation.emall.system.api.service;

import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.SecurityResourceDTO;

public interface SecurityResourceService{
    Result insertSecurityResource(SecurityResourceDTO resource);
    Result getById(Long id);
    Result updateSecurityResource(SecurityResourceDTO resource);
    Result updateDeleteStatus(SecurityResourceDTO  resource);
    Result searchList(SecurityResourceDTO resourceDTO);
}
