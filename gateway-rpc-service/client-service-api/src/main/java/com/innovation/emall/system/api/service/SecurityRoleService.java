package com.innovation.emall.system.api.service;

import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.SecurityResourceDTO;
import com.innovation.emall.system.api.entity.SecurityRoleDTO;

public interface SecurityRoleService {
    Result insertSecurityRole(SecurityRoleDTO roleDTO);
    Result getById(Long id);
    Result updateSecurityRole(SecurityRoleDTO roleDTO);
    Result updateDeleteStatus(SecurityRoleDTO roleDTO);
    Result searchList(SecurityRoleDTO roleDTO);

}
