package com.innovation.emall.api.service.controller;


import com.innnovation.emall.common.api.BaseBo;
import com.innnovation.emall.common.api.JsonResVo;
import com.innnovation.emall.common.api.enums.ErrorEnum;
import com.innovation.emall.api.service.manager.LocationManagere;
import com.innovation.emall.system.api.entity.AreaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Location")
public class LocationController {

    @Autowired
    private LocationManagere locationManagere;

    @RequestMapping(method =  {RequestMethod.POST},value = "/Location")
    @ResponseBody
    public JsonResVo addPropertyKey(@RequestBody BaseBo<AreaDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        return JsonResVo.buildSuccess(locationManagere.getLocations(baseBO.getParams().getPid()));
    }
}
