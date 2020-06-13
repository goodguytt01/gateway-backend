package com.innovation.emall.api.service.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.common.web.exception.BizException;
import com.innovation.emall.system.api.entity.SecurityRoleDTO;
import com.innovation.emall.system.api.entity.SecurityRoleDTO;
import com.innovation.emall.system.api.service.SecurityRoleService;
import com.innovation.emall.system.api.service.SecurityRoleService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityRoleManager {

    @Reference
    private SecurityRoleService securityRoleService;

    public void insertRole(SecurityRoleDTO dto){
        Result result = securityRoleService.insertSecurityRole(dto);
        if(result.success()){
            result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }


    public void updateRole(SecurityRoleDTO dto){
        Result result = securityRoleService.updateSecurityRole(dto);
        if(result.success()){
            result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public void updateDelete(SecurityRoleDTO dto){
        Result result = securityRoleService.updateSecurityRole(dto);
        if(result.success()){
            result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }


    public SecurityRoleDTO getDetail(Long id){
        Result result = securityRoleService.getById(id);
        if(result.success()){
            return (SecurityRoleDTO)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public List<SecurityRoleDTO> getList(SecurityRoleDTO dto){
        Result result = securityRoleService.searchList(dto);
        if(result.success()){
            return (List<SecurityRoleDTO>)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }
}
