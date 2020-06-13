package com.innovation.emall.system.provider.mapper;

import com.innovation.emall.system.provider.entity.ClientCompanyInfo;

public interface ClientCompanyInfoMapper {
    int insertCompanyInfo(ClientCompanyInfo client);
    ClientCompanyInfo getByClientId(Long clientId);
    int updateCompanyInfo(ClientCompanyInfo client);
}
