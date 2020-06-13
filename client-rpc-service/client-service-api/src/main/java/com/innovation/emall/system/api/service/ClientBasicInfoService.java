package com.innovation.emall.system.api.service;

import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.ClientBasicInfoDTO;

public interface ClientBasicInfoService {
    Result insertBasicInfo(ClientBasicInfoDTO dto);
}
