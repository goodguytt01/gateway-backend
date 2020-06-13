package com.innovation.emall.system.api.service;

import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.ClientCompanyInfoDTO;

public interface ClientCompanyInfoService {
    Result insertClientCompanyInfo(ClientCompanyInfoDTO dto);
}
