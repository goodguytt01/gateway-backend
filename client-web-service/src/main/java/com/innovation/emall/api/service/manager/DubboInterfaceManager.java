package com.innovation.emall.api.service.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.common.web.exception.BizException;
import com.innovation.emall.system.api.entity.ClientDTO;
import com.innovation.emall.system.api.entity.DubboInterfaceDTO;
import com.innovation.emall.system.api.service.ClientService;
import com.innovation.emall.system.api.service.DubboInterfaceService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DubboInterfaceManager {

    @Reference
    private DubboInterfaceService dubboInterfaceService;

    public String insert(DubboInterfaceDTO dubboInterfaceDTO){
        Result result = dubboInterfaceService.insert(dubboInterfaceDTO);
        if(result.success()){
            return (String)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public List<DubboInterfaceDTO> getList(){
        Result result = dubboInterfaceService.getList();
        if(result.success()){
            return (List<DubboInterfaceDTO>)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public Integer update(DubboInterfaceDTO dubboInterfaceDTO){
        Result result = dubboInterfaceService.updateInterface(dubboInterfaceDTO);
        if(result.success()){
            return (Integer)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public Integer delete(DubboInterfaceDTO dubboInterfaceDTO){
        Result result = dubboInterfaceService.deleteInterface(dubboInterfaceDTO);
        if(result.success()){
            return (Integer)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public Integer status(DubboInterfaceDTO dubboInterfaceDTO){
        Result result = dubboInterfaceService.enableOrDisable(dubboInterfaceDTO);
        if(result.success()){
            return (Integer)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public DubboInterfaceDTO getUrl(DubboInterfaceDTO dubboInterfaceDTO){
        Result result = dubboInterfaceService.getUrl(dubboInterfaceDTO);
        if(result.success()){
            return (DubboInterfaceDTO)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }
}
