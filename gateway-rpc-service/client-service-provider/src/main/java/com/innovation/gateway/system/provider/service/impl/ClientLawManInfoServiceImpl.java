package com.innovation.gateway.system.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.ClientLawManInfoDTO;
import com.innovation.emall.system.api.service.ClientLawManInfoService;
import com.innovation.gateway.system.provider.entity.ClientLawManInfo;
import com.innovation.gateway.system.provider.mapper.ClientLawManInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClientLawManInfoServiceImpl implements ClientLawManInfoService {

    @Autowired
    ClientLawManInfoMapper clientLawManInfoMapper;

    @Override
    public Result insertClientLawManInfo(ClientLawManInfoDTO dto) {
        ClientLawManInfo clientLawManInfo = clientLawManInfoMapper.getByClientId(dto.getClientId());
        if(clientLawManInfo!=null){
            BeanUtils.copyProperties(dto,clientLawManInfo);
            clientLawManInfoMapper.updateLawManInfo(clientLawManInfo);
            return Result.success(null);
        }
        clientLawManInfo = new ClientLawManInfo();
        BeanUtils.copyProperties(dto,clientLawManInfo);
        clientLawManInfoMapper.insertLawManInfo(clientLawManInfo);
        return Result.success(null);
    }
}
