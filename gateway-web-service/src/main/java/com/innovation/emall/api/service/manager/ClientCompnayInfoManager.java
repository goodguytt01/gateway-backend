package com.innovation.emall.api.service.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.common.web.exception.BizException;
import com.innovation.emall.system.api.entity.ClientCompanyInfoDTO;
import com.innovation.emall.system.api.service.ClientCompanyInfoService;
import org.springframework.stereotype.Component;

@Component
public class ClientCompnayInfoManager {

    @Reference
    ClientCompanyInfoService clientCompanyInfoService;

    public void insertCompanyInfo(ClientCompanyInfoDTO dto){
        Result result = clientCompanyInfoService.insertClientCompanyInfo(dto);
        if(result.success()){
            result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }
}
