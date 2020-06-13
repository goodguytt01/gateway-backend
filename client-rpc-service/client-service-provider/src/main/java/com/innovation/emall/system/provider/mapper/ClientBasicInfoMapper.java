package com.innovation.emall.system.provider.mapper;

import com.innovation.emall.system.provider.entity.ClientBasicInfo;

public interface ClientBasicInfoMapper {
    int insertBasicInfo(ClientBasicInfo client);
    ClientBasicInfo getByClientId(Long clientId);
    int updateBasicInfo(ClientBasicInfo client);
}
