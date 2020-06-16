package com.innovation.gateway.system.provider.mapper;

import com.innovation.gateway.system.provider.entity.ClientBasicInfo;

public interface ClientBasicInfoMapper {
    int insertBasicInfo(ClientBasicInfo client);
    ClientBasicInfo getByClientId(Long clientId);
    int updateBasicInfo(ClientBasicInfo client);
}
