package com.innovation.emall.api.service.controller;

import com.innnovation.emall.common.api.BaseBo;
import com.innnovation.emall.common.api.JsonResVo;
import com.innnovation.emall.common.api.enums.ErrorEnum;
import com.innovation.emall.api.service.manager.SecurityRoleManager;
import com.innovation.emall.system.api.entity.SecurityRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Security")
public class SecurityRoleController {

    @Autowired
    private SecurityRoleManager securityRoleManager;

    @RequestMapping(method =  {RequestMethod.POST},value = "/Role")
    @ResponseBody
    public JsonResVo addRole(@RequestBody BaseBo<SecurityRoleDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        securityRoleManager.insertRole(baseBO.getParams());
        return JsonResVo.buildSuccess();
    }

    @RequestMapping(method =  {RequestMethod.POST},value = "/Role/Update")
    @ResponseBody
    public JsonResVo updateRole(@RequestBody BaseBo<SecurityRoleDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        securityRoleManager.updateRole(baseBO.getParams());
        return JsonResVo.buildSuccess();
    }


    @RequestMapping(method =  {RequestMethod.POST},value = "/Role/Status/Update")
    @ResponseBody
    public JsonResVo updateDeleteFlag(@RequestBody BaseBo<SecurityRoleDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        securityRoleManager.updateDelete(baseBO.getParams());
        return JsonResVo.buildSuccess();
    }

    @RequestMapping(method =  {RequestMethod.GET},value = "/Role")
    @ResponseBody
    public JsonResVo getRole(@RequestBody BaseBo<SecurityRoleDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        SecurityRoleDTO dto = securityRoleManager.getDetail(baseBO.getParams().getId());
        return JsonResVo.buildSuccess(dto);
    }

    @RequestMapping(method =  {RequestMethod.GET},value = "/Roles")
    @ResponseBody
    public JsonResVo getRoles(@RequestBody BaseBo<SecurityRoleDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        List<SecurityRoleDTO> dtos = securityRoleManager.getList(baseBO.getParams());
        return JsonResVo.buildSuccess(dtos);
    }

}
