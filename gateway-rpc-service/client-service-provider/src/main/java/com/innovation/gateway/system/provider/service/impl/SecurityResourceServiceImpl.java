package com.innovation.gateway.system.provider.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.SecurityResourceDTO;
import com.innovation.emall.system.api.service.SecurityResourceService;
import com.innovation.gateway.system.provider.entity.SecurityResource;
import com.innovation.gateway.system.provider.mapper.SecurityResourceMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.innnovation.emall.common.api.enums.ERROR_ENUM.EMPTY_PARAMETER;

@Service
public class SecurityResourceServiceImpl implements SecurityResourceService {

    @Autowired
    SecurityResourceMapper securityResourceMapper;

    @Override
    public Result insertSecurityResource(SecurityResourceDTO resource) {
        if(StringUtils.isEmpty(resource.getName())||StringUtils.isEmpty(resource.getName())){
            return new Result(EMPTY_PARAMETER);
        }
        SecurityResource securityResource = new SecurityResource();
        BeanUtils.copyProperties(resource,securityResource);
        securityResourceMapper.insertSecurityResource(securityResource);
        return Result.success(1L);
    }

    @Override
    public Result getById(Long id) {
        if(id==null||id==0){
            return new Result(EMPTY_PARAMETER);
        }
        SecurityResourceDTO dto = new SecurityResourceDTO();
        BeanUtils.copyProperties(securityResourceMapper.getById(id),dto);
        return Result.success(dto);
    }

    @Override
    public Result updateSecurityResource(SecurityResourceDTO resource) {
        if(resource.getId()==null||resource.getId()==0||StringUtils.isEmpty(resource.getName())||StringUtils.isEmpty(resource.getUrl())) {
            return new Result(EMPTY_PARAMETER);
        }
        SecurityResource securityResource = new SecurityResource();
        BeanUtils.copyProperties(resource,securityResource);
        return Result.success(securityResourceMapper.updateSecurityResource(securityResource));
    }

    @Override
    public Result updateDeleteStatus(SecurityResourceDTO securityResource) {
        if(securityResource.getId()==null||securityResource.getId()==0){
            return new Result(EMPTY_PARAMETER);
        }
        SecurityResource resource = new SecurityResource();
        BeanUtils.copyProperties(securityResource,resource);
        securityResourceMapper.updateDeleteStatus(resource);
        return Result.success(1L);

    }

    @Override
    public Result searchList(SecurityResourceDTO resourceDTO) {
        SecurityResource resource = new SecurityResource();
        BeanUtils.copyProperties(resourceDTO,resource);
        List<SecurityResource> resources = securityResourceMapper.searchList(resource);
        List<SecurityResourceDTO> dtos = new ArrayList<>();
        for(SecurityResource securityResource:resources){
            SecurityResourceDTO dto = new SecurityResourceDTO();
            BeanUtils.copyProperties(securityResource,dto);
            dtos.add(dto);
        }
        return Result.success(dtos);
    }
}
