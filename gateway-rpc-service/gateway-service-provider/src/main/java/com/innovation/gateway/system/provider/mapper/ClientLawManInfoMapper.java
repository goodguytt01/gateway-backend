package com.innovation.gateway.system.provider.mapper;

import com.innovation.gateway.system.provider.entity.ClientLawManInfo;

public interface ClientLawManInfoMapper {
    int insertLawManInfo(ClientLawManInfo client);
    ClientLawManInfo getByClientId(Long clientId);
    int updateLawManInfo(ClientLawManInfo client);
}
