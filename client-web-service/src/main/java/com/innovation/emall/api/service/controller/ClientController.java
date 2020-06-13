package com.innovation.emall.api.service.controller;

import com.innnovation.emall.common.api.BaseBo;
import com.innnovation.emall.common.api.JsonResVo;
import com.innnovation.emall.common.api.enums.ErrorEnum;
import com.innovation.emall.api.service.manager.ClientManager;
import com.innovation.emall.system.api.entity.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Client")
public class ClientController {

    @Autowired
    private ClientManager clientManager;

    @RequestMapping(method =  {RequestMethod.POST},value = "/Register")
    @ResponseBody
    public JsonResVo registerClient(@RequestBody BaseBo<ClientDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        return JsonResVo.buildSuccess(clientManager.registerClient(baseBO.getParams()));
    }


    @RequestMapping(method =  {RequestMethod.POST},value = "/Login")
    @ResponseBody
    public JsonResVo loginClient(@RequestBody BaseBo<ClientDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        return JsonResVo.buildSuccess(clientManager.Login(baseBO.getParams()));
    }


    @RequestMapping(method =  {RequestMethod.POST},value = "/SendValidCode")
    @ResponseBody
    public JsonResVo sendValidCode(@RequestBody BaseBo<ClientDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        clientManager.sendValidCode(baseBO.getParams());
        return JsonResVo.buildSuccess();
    }

    @RequestMapping(method =  {RequestMethod.POST},value = "/Status")
    @ResponseBody
    public JsonResVo setupStatus(@RequestBody BaseBo<ClientDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        clientManager.setupStatus(baseBO.getParams());
        return JsonResVo.buildSuccess();
    }
}
