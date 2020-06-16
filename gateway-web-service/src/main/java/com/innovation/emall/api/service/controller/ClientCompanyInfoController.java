package com.innovation.emall.api.service.controller;


import com.innnovation.emall.common.api.BaseBo;
import com.innnovation.emall.common.api.JsonResVo;
import com.innnovation.emall.common.api.enums.ErrorEnum;
import com.innnovation.emall.common.api.utils.JWTHelper;
import com.innovation.emall.api.service.manager.ClientCompnayInfoManager;
import com.innovation.emall.system.api.entity.ClientCompanyInfoDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Client/Company")
public class ClientCompanyInfoController {

    @Autowired
    private ClientCompnayInfoManager clientCompnayInfoManager;

    @RequestMapping(method =  {RequestMethod.POST},value = "/Info")
    @ResponseBody
    public JsonResVo registerClient(@RequestBody @Valid BaseBo<ClientCompanyInfoDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        ClientCompanyInfoDTO dto = baseBO.getParams();
        if(StringUtils.isEmpty(dto.getAreaId())||StringUtils.isEmpty(dto.getBizRunScope())||StringUtils.isEmpty(dto.getCityId())||StringUtils.isEmpty(dto.getCompanyAddress())||StringUtils.isEmpty(dto.getCompanyName())||StringUtils.isEmpty(dto.getProvinceId())||dto.getRunDueDate()==null||StringUtils.isEmpty(dto.getSocialCreditLicenceImage())||StringUtils.isEmpty(dto.getSocialCreditNo())||StringUtils.isEmpty(dto.getToken())){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        Long clientId = JWTHelper.getAppUID(dto.getToken());
        dto.setClientId(clientId);
        clientCompnayInfoManager.insertCompanyInfo(baseBO.getParams());
        return JsonResVo.buildSuccess();
    }
}
