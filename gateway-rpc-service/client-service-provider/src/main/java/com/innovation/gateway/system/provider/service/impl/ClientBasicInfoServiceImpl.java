package com.innovation.gateway.system.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.ClientBasicInfoDTO;
import com.innovation.emall.system.api.service.ClientBasicInfoService;
import com.innovation.gateway.system.provider.entity.ClientBasicInfo;
import com.innovation.gateway.system.provider.mapper.ClientBasicInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import static com.innnovation.emall.common.api.enums.ERROR_ENUM.EMPTY_PARAMETER;

@Service
public class ClientBasicInfoServiceImpl implements ClientBasicInfoService {

    @Autowired
    private ClientBasicInfoMapper clientIdentificationMapper;

    @Override
    public Result insertBasicInfo(ClientBasicInfoDTO dto) {
        if(StringUtils.isEmpty(dto.getAddressDetail())||StringUtils.isEmpty(dto.getAdminEmail())||StringUtils.isEmpty(dto.getAreaId())||StringUtils.isEmpty(dto.getCityId())||StringUtils.isEmpty(dto.getProvinceId())||StringUtils.isEmpty(dto.getClientServicePhone())||StringUtils.isEmpty(dto.getShopCategoryId())||StringUtils.isEmpty(dto.getRealName())||StringUtils.isEmpty(dto.getShopLatitude())||StringUtils.isEmpty(dto.getShopLongitude())){
            return new Result(EMPTY_PARAMETER);
        }
        ClientBasicInfo clientIdentification = clientIdentificationMapper.getByClientId(dto.getClientId());
        if(clientIdentification!=null){
            BeanUtils.copyProperties(dto,clientIdentification);
            clientIdentificationMapper.updateBasicInfo(clientIdentification);
            return Result.success(1L);
        }
        BeanUtils.copyProperties(dto,clientIdentification);
        clientIdentificationMapper.insertBasicInfo(clientIdentification);
        return Result.success(1L);
    }
}
