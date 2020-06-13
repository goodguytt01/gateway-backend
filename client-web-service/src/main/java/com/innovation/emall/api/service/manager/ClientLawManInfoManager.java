package com.innovation.emall.api.service.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.common.web.exception.BizException;
import com.innovation.emall.system.api.entity.ClientLawManInfoDTO;
import com.innovation.emall.system.api.service.ClientLawManInfoService;
import org.springframework.stereotype.Component;

@Component
public class ClientLawManInfoManager {

    @Reference
    ClientLawManInfoService clientLawManInfoService;

    public void insertLawManInfo(ClientLawManInfoDTO dto){
        Result result = clientLawManInfoService.insertClientLawManInfo(dto);
        if(result.success()){
            result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }
}
