package com.innovation.emall.api.service.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.common.web.exception.BizException;
import com.innovation.emall.system.api.entity.ClientBasicInfoDTO;
import com.innovation.emall.system.api.service.ClientBasicInfoService;
import org.springframework.stereotype.Component;

@Component
public class ClientBasicInfoManager {

    @Reference
    ClientBasicInfoService clientBasicInfoService;

    public void insertBasicInfo(ClientBasicInfoDTO dto){
        Result result = clientBasicInfoService.insertBasicInfo(dto);
        if(result.success()){
            result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }
}
