package com.innovation.emall.system.provider.mapper;

import com.innovation.emall.system.provider.entity.ClientCompanyInfo;
import com.innovation.emall.system.provider.entity.ClientLawManInfo;

public interface ClientLawManInfoMapper {
    int insertLawManInfo(ClientLawManInfo client);
    ClientLawManInfo getByClientId(Long clientId);
    int updateLawManInfo(ClientLawManInfo client);
}
