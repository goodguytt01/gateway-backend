package com.innovation.gateway.system.provider.mapper;

import com.innovation.gateway.system.provider.entity.ClientCompanyInfo;

public interface ClientCompanyInfoMapper {
    int insertCompanyInfo(ClientCompanyInfo client);
    ClientCompanyInfo getByClientId(Long clientId);
    int updateCompanyInfo(ClientCompanyInfo client);
}
