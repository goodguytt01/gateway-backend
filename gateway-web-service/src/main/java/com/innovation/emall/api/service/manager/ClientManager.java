package com.innovation.emall.api.service.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.common.web.exception.BizException;
import com.innovation.emall.system.api.entity.ClientDTO;
import com.innovation.emall.system.api.service.ClientService;
import org.springframework.stereotype.Component;

@Component
public class ClientManager {

    @Reference
    ClientService clientService;

    public String registerClient(ClientDTO clientDTO){
        Result result = clientService.insert(clientDTO);
        if(result.success()){
            return (String)result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public String Login(ClientDTO clientDTO){
        Result result = clientService.login(clientDTO);
        if(result.success()){
            return (String) result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public void sendValidCode(ClientDTO clientDTO){
        Result result = clientService.sendValidCode(clientDTO);
        if(result.success()){
            result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }

    public void setupStatus(ClientDTO clientDTO){
        Result result = clientService.setStatus(clientDTO);
        if(result.success()){
            result.getData();
        }else{
            throw new BizException(result.getCode(),result.getMsg());
        }
    }
}
