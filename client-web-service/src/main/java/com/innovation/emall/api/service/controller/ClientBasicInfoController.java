package com.innovation.emall.api.service.controller;


import com.innnovation.emall.common.api.BaseBo;
import com.innnovation.emall.common.api.JsonResVo;
import com.innnovation.emall.common.api.enums.ErrorEnum;
import com.innnovation.emall.common.api.utils.JWTHelper;
import com.innovation.emall.api.service.manager.ClientBasicInfoManager;
import com.innovation.emall.system.api.entity.ClientBasicInfoDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Client/Basic")
public class ClientBasicInfoController {

    @Autowired
    private ClientBasicInfoManager ClientIdentificationManager;

    @RequestMapping(method =  {RequestMethod.POST},value = "/Info")
    @ResponseBody
    public JsonResVo registerClient(@RequestBody @Valid BaseBo<ClientBasicInfoDTO> baseBO){
        if(baseBO==null||baseBO.getParams()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        ClientBasicInfoDTO dto = baseBO.getParams();
        if(StringUtils.isEmpty(dto.getAddressDetail())||StringUtils.isEmpty(dto.getAdminEmail())||StringUtils.isEmpty(dto.getAreaId())||StringUtils.isEmpty(dto.getCityId())||StringUtils.isEmpty(dto.getProvinceId())||StringUtils.isEmpty(dto.getClientServicePhone())||StringUtils.isEmpty(dto.getShopCategoryId())||StringUtils.isEmpty(dto.getRealName())||StringUtils.isEmpty(dto.getShopLatitude())||StringUtils.isEmpty(dto.getShopLongitude())){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        if(StringUtils.isEmpty(dto.getToken())){
            return JsonResVo.buildErrorResult(ErrorEnum.ERROR_PARAM);
        }
        Long clientId = JWTHelper.getAppUID(dto.getToken());
        dto.setClientId(clientId);
        ClientIdentificationManager.insertBasicInfo(baseBO.getParams());
        return JsonResVo.buildSuccess();
    }
}
