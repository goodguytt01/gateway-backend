package com.innovation.emall.system.provider.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.ClientDTO;
import com.innovation.emall.system.api.service.ClientService;
import com.innovation.emall.system.provider.entity.Client;
import com.innovation.emall.system.provider.entity.ClientLoginLog;
import com.innovation.emall.system.provider.mapper.ClientLoginLogMapper;
import com.innovation.emall.system.provider.mapper.ClientMapper;
import com.innnovation.emall.common.api.utils.JWTHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

import static com.innnovation.emall.common.api.enums.ERROR_ENUM.*;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientMapper clientMapper;


    @Autowired
    RedisTemplate redisTemplate;


    @Autowired
    ClientLoginLogMapper clientLoginLogMapper;

    private static final String VALID_CODE_PREFIX = "VALID_CODE_CACHE_PREFIX";

    @Override
    @Transactional
    public Result insert(ClientDTO clientDTO){
        if(StringUtils.isEmpty(clientDTO.getMobile())||StringUtils.isEmpty(clientDTO.getValidCode())) {
            return new Result(EMPTY_PARAMETER);
        }
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        if (!Pattern.matches(regex, clientDTO.getMobile())) {
            return new Result(WRONG_MOBILE_PATTERN);
        }
        Client client = new Client();
        client = clientMapper.getByMobile(clientDTO.getMobile());
        if(client!=null){
            return new Result(DUPLICATED_MOBILE);
        }
        String validCode = clientDTO.getValidCode();
        Object tmpObj =  redisTemplate.opsForValue().get(VALID_CODE_PREFIX+"/"+ clientDTO.getMobile());
        if(tmpObj!=null){
            String originValidCode = (String)tmpObj;
            if(!validCode.equals(originValidCode)){
                return new Result(VALID_CODE_ERROR);
            }
        }else {
            return new Result(SEMD_VALID_CODE_BEFORE_LOGIN);
        }

        BeanUtils.copyProperties(clientDTO,client);
        client.setDeleteFlag(false);
        clientMapper.insert(client);
        clientDTO.setClientId(client.getId());
        addLog(clientDTO);
        try {
            return Result.success(JWTHelper.createToken(client.getId()));
        }catch (Exception e){
            return new Result(SYSTEM_ERROR);        }
    }

    @Override
    public Result login(ClientDTO clientDTO){
        if(clientDTO.getLoginType()==0){
            return new Result(EMPTY_PARAMETER);
        }
        Client client = new Client();
        if(clientDTO.getLoginType()==1){
            if(StringUtils.isEmpty(clientDTO.getValidCode())){
                return new Result(EMPTY_PARAMETER);
            }
            if(clientDTO.getValidCode().equals(redisTemplate.opsForValue().get(VALID_CODE_PREFIX+"/"+ clientDTO.getMobile()))){
                    client = clientMapper.getByMobile(clientDTO.getMobile());
                    if(client==null){
                        return new Result(USER_NOT_EXIST_ERROR_STATUS);
                    }
                    clientDTO.setClientId(client.getId());
                    clientDTO.setLoginType(2);
                    addLog(clientDTO);
                    clientDTO.setLoginType(1);
            }
        }
        if(clientDTO.getLoginType()==2){
            if(StringUtils.isEmpty(clientDTO.getPassword())){
                return new Result(EMPTY_PARAMETER);
            }

            client.setMobile(clientDTO.getMobile());
            client.setPassword(clientDTO.getPassword());
            client = clientMapper.getByMobile(clientDTO.getMobile());
            if(client==null){
                return new Result(USER_NOT_EXIST_ERROR_STATUS);
            }
            client = clientMapper.loginByPassword(client);
            if(client==null){
                return new Result(WRONG_PASS);
            }

        }
        try {
            return Result.success(JWTHelper.createToken(client.getId()));
        }catch (Exception e){
            return new Result(SYSTEM_ERROR);
        }
    }

    @Override
    public Result sendValidCode(ClientDTO clientDTO){
        if(StringUtils.isEmpty(clientDTO.getMobile())){
            return new Result(EMPTY_PARAMETER);
        }
//        redisTemplate.opsForValue().set(VALID_CODE_PREFIX+"/"+ clientDTO.getMobile(),getRandomNum());
          redisTemplate.opsForValue().set(VALID_CODE_PREFIX+"/"+ clientDTO.getMobile(),"8888");
          return Result.success(null);
    }

    @Override
    public Result setStatus(ClientDTO clientDTO){
        if(StringUtils.isEmpty(clientDTO.getMobile())){
            return new Result(EMPTY_PARAMETER);
        }
        Client client = new Client();
        client.setMobile(clientDTO.getMobile());
        client.setStatus(1);
        int result =  clientMapper.updateStatus(client);
        return Result.success(null);
    }

    private String getRandomNum(){
        String s = "";
        for(int i=0;i<4;i++) {
         Integer k  = (int) (1 + Math.random() * 10);
         s = s + k.toString();
        }
        return s;
    }


    private int addLog(ClientDTO clientDTO){
        ClientLoginLog loginLog = new ClientLoginLog();
        loginLog.setChannel(clientDTO.getChannel());
        loginLog.setClientId(clientDTO.getClientId());
        loginLog.setType(clientDTO.getLoginType());
        clientLoginLogMapper.insert(loginLog);
        return 1;
    }
}

