package com.innovation.emall.api.service.controller;

import com.innnovation.emall.common.api.BaseBo;
import com.innnovation.emall.common.api.JsonResVo;
import com.innnovation.emall.common.api.enums.ErrorEnum;
import com.innovation.emall.api.service.manager.SecurityResourceManager;
import com.innovation.emall.system.api.entity.SecurityResourceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Security")
public class SecurityResourceController {

    @Autowired
    private SecurityResourceManager securityResourceManager;

    @RequestMapping(method =  {RequestMethod.POST},value = "/Resource")
    @ResponseBody
    public JsonResVo addResource(@RequestBody BaseBo<SecurityResourceDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        securityResourceManager.insertResource(baseBO.getParams());
        return JsonResVo.buildSuccess();
    }

    @RequestMapping(method =  {RequestMethod.POST},value = "/Resource/Update")
    @ResponseBody
    public JsonResVo updateResource(@RequestBody BaseBo<SecurityResourceDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        securityResourceManager.updateResource(baseBO.getParams());
        return JsonResVo.buildSuccess();
    }


    @RequestMapping(method =  {RequestMethod.POST},value = "/Resource/Status/Update")
    @ResponseBody
    public JsonResVo updateDeleteFlag(@RequestBody BaseBo<SecurityResourceDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        securityResourceManager.updateDelete(baseBO.getParams());
        return JsonResVo.buildSuccess();
    }

    @RequestMapping(method =  {RequestMethod.GET},value = "/Resource")
    @ResponseBody
    public JsonResVo getResource(@RequestBody BaseBo<SecurityResourceDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        SecurityResourceDTO dto = securityResourceManager.getDetail(baseBO.getParams().getId());
        return JsonResVo.buildSuccess(dto);
    }

    @RequestMapping(method =  {RequestMethod.GET},value = "/Resources")
    @ResponseBody
    public JsonResVo getResources(@RequestBody BaseBo<SecurityResourceDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        List<SecurityResourceDTO> dtos = securityResourceManager.getList(baseBO.getParams());
        return JsonResVo.buildSuccess(dtos);
    }

}
