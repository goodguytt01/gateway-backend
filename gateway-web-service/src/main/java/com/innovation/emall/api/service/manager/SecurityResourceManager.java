package com.innovation.emall.api.service.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.common.web.exception.BizException;
import com.innovation.emall.system.api.entity.SecurityResourceDTO;
import com.innovation.emall.system.api.service.SecurityResourceService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityResourceManager {

    @Reference
    private SecurityResourceService securityResourceService;

    public void insertResource(SecurityResourceDTO dto){
        Result result = securityResourceService.insertSecurityResource(dto);
        if(result.success()){
            result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }


    public void updateResource(SecurityResourceDTO dto){
        Result result = securityResourceService.updateSecurityResource(dto);
        if(result.success()){
            result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public void updateDelete(SecurityResourceDTO dto){
        Result result = securityResourceService.updateSecurityResource(dto);
        if(result.success()){
            result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }


    public SecurityResourceDTO getDetail(Long id){
        Result result = securityResourceService.getById(id);
        if(result.success()){
            return (SecurityResourceDTO)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public List<SecurityResourceDTO> getList(SecurityResourceDTO dto){
        Result result = securityResourceService.searchList(dto);
        if(result.success()){
            return (List<SecurityResourceDTO>)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }
}
