package com.innovation.emall.api.service.controller;

import com.innnovation.emall.common.api.BaseBo;
import com.innnovation.emall.common.api.JsonResVo;
import com.innnovation.emall.common.api.enums.ErrorEnum;
import com.innnovation.emall.common.api.utils.JWTHelper;
import com.innovation.emall.api.service.manager.ClientLawManInfoManager;
import com.innovation.emall.system.api.entity.ClientLawManInfoDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Client/LawMan")
public class ClientLawManInfoController {

    @Autowired
    private ClientLawManInfoManager clientLawManInfoManager;

    @RequestMapping(method =  {RequestMethod.POST},value = "/Info")
    @ResponseBody
    public JsonResVo registerClient(@RequestBody @Valid BaseBo<ClientLawManInfoDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        ClientLawManInfoDTO dto = baseBO.getParams();
        if(dto.getLawManLicenceDueDateType()==0||dto.getLawManLicenceEndDate()==null||dto.getLawManLicenceStartDate()==null||StringUtils.isEmpty(dto.getLawManName())||dto.getLawManType()==0||StringUtils.isEmpty(dto.getLicenceImageBack())||StringUtils.isEmpty(dto.getLicenceImageFront())||StringUtils.isEmpty(dto.getLicenceImageHand())){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        Long clientId = JWTHelper.getAppUID(dto.getToken());
        dto.setClientId(clientId);
        clientLawManInfoManager.insertLawManInfo(dto);
        return JsonResVo.buildSuccess();
    }

}
