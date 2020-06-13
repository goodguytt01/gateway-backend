package com.innovation.emall.api.service.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.common.web.exception.BizException;
import com.innovation.emall.system.api.entity.DubboInterfaceDTO;
import com.innovation.emall.system.api.entity.DubboMethodDTO;
import com.innovation.emall.system.api.service.DubboInterfaceService;
import com.innovation.emall.system.api.service.DubboMethodService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DubboMethodManager {

    @Reference
    private DubboMethodService dubboInterfaceService;

    public String insert(DubboMethodDTO dubboMethodDTO){
        Result result = dubboInterfaceService.insert(dubboMethodDTO);
        if(result.success()){
            return (String)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public List<DubboMethodDTO> getList(DubboMethodDTO dubboMethodDTO){
        Result result = dubboInterfaceService.getList(dubboMethodDTO);
        if(result.success()){
            return (List<DubboMethodDTO>)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public Integer delete(DubboMethodDTO dubboMethodDTO){
        Result result = dubboInterfaceService.delete(dubboMethodDTO);
        if(result.success()){
            return (Integer)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public Integer updateStatus(DubboMethodDTO dubboMethodDTO){
        Result result = dubboInterfaceService.updateStatus(dubboMethodDTO);
        if(result.success()){
            return (Integer)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public DubboMethodDTO getById(Long id){
        Result result = dubboInterfaceService.getById(id);
        if(result.success()){
            return (DubboMethodDTO)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }


    public DubboMethodDTO getByUrl(String url){
        Result result = dubboInterfaceService.getByUrl(url);
        if(result.success()){
            return (DubboMethodDTO)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }
}
