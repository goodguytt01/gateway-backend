package com.innovation.gateway.system.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.ClientCompanyInfoDTO;
import com.innovation.emall.system.api.service.ClientCompanyInfoService;
import com.innovation.gateway.system.provider.entity.ClientCompanyInfo;
import com.innovation.gateway.system.provider.mapper.ClientCompanyInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClientCompanyInfoServceImpl implements ClientCompanyInfoService {

    @Autowired
    ClientCompanyInfoMapper clientCompanyInfoMapper;

    @Override
    public Result insertClientCompanyInfo(ClientCompanyInfoDTO dto) {
        ClientCompanyInfo clientCompanyInfo = clientCompanyInfoMapper.getByClientId(dto.getClientId());
        if(clientCompanyInfo!=null){
            BeanUtils.copyProperties(dto,clientCompanyInfo);
            clientCompanyInfoMapper.updateCompanyInfo(clientCompanyInfo);
            return Result.success(null);
        }
        clientCompanyInfo = new ClientCompanyInfo();
        BeanUtils.copyProperties(dto,clientCompanyInfo);
        clientCompanyInfoMapper.insertCompanyInfo(clientCompanyInfo);
        return Result.success(null);
    }
}
