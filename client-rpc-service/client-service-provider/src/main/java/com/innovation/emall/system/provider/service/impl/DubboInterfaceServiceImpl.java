package com.innovation.emall.system.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.DubboInterfaceDTO;
import com.innovation.emall.system.api.service.DubboInterfaceService;
import com.innovation.emall.system.provider.entity.DubboInterface;
import com.innovation.emall.system.provider.mapper.DubboInterfaceMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class DubboInterfaceServiceImpl implements DubboInterfaceService {

    @Autowired
    private DubboInterfaceMapper dubboInterfaceMapper;

    @Override
    public Result insert(DubboInterfaceDTO dubboInterfaceDTO) {
        DubboInterface dubboInterface = new DubboInterface();
        BeanUtils.copyProperties(dubboInterfaceDTO,dubboInterface);
        dubboInterfaceMapper.insert(dubboInterface);
        return Result.success(null);
    }

    @Override
    public Result getList() {
      List<DubboInterface> interfaces =  dubboInterfaceMapper.getList();
      List<DubboInterfaceDTO> dtos = new ArrayList<>();
      for(DubboInterface dubboInterface:interfaces){
          DubboInterfaceDTO interfaceDTO = new DubboInterfaceDTO();
          BeanUtils.copyProperties(dubboInterface,interfaceDTO);
          dtos.add(interfaceDTO);
      }
      return Result.success(dtos);
    }

    @Override
    public Result getUrl(DubboInterfaceDTO dubboInterfaceDTO) {
        DubboInterface dubboInterface = new DubboInterface();
        BeanUtils.copyProperties(dubboInterfaceMapper.getUrl(dubboInterface),dubboInterfaceDTO);
        return Result.success(dubboInterfaceDTO);
    }

    @Override
    public Result updateInterface(DubboInterfaceDTO dubboInterfaceDTO) {
        DubboInterface dubboInterface = new DubboInterface();
        BeanUtils.copyProperties(dubboInterfaceDTO,dubboInterface);
        return Result.success(dubboInterfaceMapper.updateInterface(dubboInterface));
    }

    @Override
    public Result deleteInterface(DubboInterfaceDTO dubboInterfaceDTO) {
        DubboInterface dubboInterface = new DubboInterface();
        BeanUtils.copyProperties(dubboInterfaceDTO,dubboInterface);
        return Result.success(dubboInterfaceMapper.deleteInterface(dubboInterface));
    }

    @Override
    public Result enableOrDisable(DubboInterfaceDTO dubboInterfaceDTO) {
        DubboInterface dubboInterface = new DubboInterface();
        BeanUtils.copyProperties(dubboInterfaceDTO,dubboInterface);
        return Result.success(dubboInterfaceMapper.enableOrDisable (dubboInterface));
    }

    @Override
    public Result getById(Long id) {
        DubboInterfaceDTO interfaceDTO = new DubboInterfaceDTO();
        DubboInterface dubboInterface = dubboInterfaceMapper.getById(id);
        BeanUtils.copyProperties(dubboInterface,interfaceDTO);
        return Result.success(interfaceDTO);
    }
}
