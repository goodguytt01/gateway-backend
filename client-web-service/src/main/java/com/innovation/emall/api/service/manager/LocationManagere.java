package com.innovation.emall.api.service.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.common.web.exception.BizException;
import com.innovation.emall.system.api.entity.AreaDTO;
import com.innovation.emall.system.api.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationManagere {

    @Reference
    private LocationService locationService;

    public List<AreaDTO> getLocations(Long parentId){
        Result result = locationService.getLocations(parentId);
        if(result.success()){
            return (List<AreaDTO>)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }
}
