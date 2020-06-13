package com.innovation.emall.system.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.DubboMethodDTO;
import com.innovation.emall.system.api.service.DubboMethodService;
import com.innovation.emall.system.provider.entity.DubboMethod;
import com.innovation.emall.system.provider.mapper.DubboMethodMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class  DubboMethodServiceImpl  implements DubboMethodService {


    @Autowired
    DubboMethodMapper dubboMethodMapper;

    @Override
    public Result insert(DubboMethodDTO dubboMethodDTO) {
        DubboMethod dubboMethod = new DubboMethod();
        BeanUtils.copyProperties(dubboMethodDTO,dubboMethod);
        return Result.success(dubboMethodMapper.insert(dubboMethod));
    }

    @Override
    public Result getList(DubboMethodDTO dubboMethodDTO) {
        DubboMethod dubboMethod = new DubboMethod();
        BeanUtils.copyProperties(dubboMethodDTO,dubboMethod);
        List<DubboMethod> list = dubboMethodMapper.getList(dubboMethod);
        List<DubboMethodDTO> dubboMethodDTOS = new ArrayList<>();
        List<DubboMethod> methods = new ArrayList<>();
        for(DubboMethod method:list){
            DubboMethodDTO dto = new DubboMethodDTO();
            BeanUtils.copyProperties(method,dto);
            dubboMethodDTOS.add(dto);
        }
        return Result.success(dubboMethodDTOS);
    }

    @Override
    public Result getById(Long id) {
        DubboMethod dubboMethod = dubboMethodMapper.getById(id);
        DubboMethodDTO dubboMethodDTO = new DubboMethodDTO();
        BeanUtils.copyProperties(dubboMethod,dubboMethodDTO);
        return Result.success(dubboMethodDTO);
    }

    @Override
    public Result getByUrl(String url) {
        DubboMethod dubboMethod = dubboMethodMapper.getUrl(url);
        DubboMethodDTO dubboMethodDTO = new DubboMethodDTO();
        BeanUtils.copyProperties(dubboMethod,dubboMethodDTO);
        return Result.success(dubboMethodDTO);
    }

    @Override
    public Result delete(DubboMethodDTO dubboMethodDTO) {
        DubboMethod dubboMethod = new DubboMethod();
        BeanUtils.copyProperties(dubboMethodDTO,dubboMethod);
        return Result.success(dubboMethodMapper.updateDeleteStatus(dubboMethod));
    }

    @Override
    public Result updateStatus(DubboMethodDTO dubboMethodDTO) {
        DubboMethod dubboMethod = new DubboMethod();
        BeanUtils.copyProperties(dubboMethodDTO,dubboMethod);
        return Result.success(dubboMethodMapper.updateStatus(dubboMethod));
    }
}
