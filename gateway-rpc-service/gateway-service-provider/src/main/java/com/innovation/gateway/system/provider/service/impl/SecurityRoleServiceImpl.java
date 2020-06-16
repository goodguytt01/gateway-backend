package com.innovation.gateway.system.provider.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.SecurityResourceDTO;
import com.innovation.emall.system.api.entity.SecurityRoleDTO;
import com.innovation.emall.system.api.service.SecurityRoleService;
import com.innovation.gateway.system.provider.entity.SecurityRole;
import com.innovation.gateway.system.provider.mapper.SecurityRoleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import static com.innnovation.emall.common.api.enums.ERROR_ENUM.EMPTY_PARAMETER;

@Service
public  class SecurityRoleServiceImpl implements SecurityRoleService {

    @Autowired
    SecurityRoleMapper securityRoleMapper;

    @Override
    public Result insertSecurityRole(SecurityRoleDTO roleDTO){
        if(StringUtils.isEmpty(roleDTO.getName())){
            return new Result(EMPTY_PARAMETER);
        }
        SecurityRole role = new SecurityRole();
        BeanUtils.copyProperties(roleDTO,role);
        securityRoleMapper.insertSecurityRole(role);
        return Result.success(1L);
    }

    @Override
    public Result getById(Long id) {
        if(id==null||id==0){
            return new Result(EMPTY_PARAMETER);
        }
        SecurityResourceDTO dto = new SecurityResourceDTO();
        BeanUtils.copyProperties(securityRoleMapper.getById(id),dto);
        return Result.success(dto);
    }


    @Override
    public Result updateSecurityRole(SecurityRoleDTO roleDTO) {
        if(roleDTO.getId()==null||roleDTO.getId()==0||StringUtils.isEmpty(roleDTO.getName())) {
            return new Result(EMPTY_PARAMETER);
        }
        SecurityRole role = new SecurityRole();
        BeanUtils.copyProperties(roleDTO,role);
        return Result.success(securityRoleMapper.updateSecurityRole(role));
    }

    @Override
    public Result updateDeleteStatus(SecurityRoleDTO roleDTO) {
        if(roleDTO.getId()==null||roleDTO.getId()==0){
            return new Result(EMPTY_PARAMETER);
        }
        SecurityRole role = new SecurityRole();
        BeanUtils.copyProperties(roleDTO,role);
        securityRoleMapper.updateDeleteStatus(role);
        return Result.success(1L);

    }

    @Override
    public Result searchList(SecurityRoleDTO roleDTO) {
        SecurityRole role = new SecurityRole();
        BeanUtils.copyProperties(roleDTO,role);
        return Result.success(securityRoleMapper.searchList(role));
    }
}
