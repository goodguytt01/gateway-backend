package com.innovation.emall.system.api.service;

import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.DubboMethodDTO;

import java.util.List;

public interface DubboMethodService {
    Result insert(DubboMethodDTO dubboMethod);
    Result getList(DubboMethodDTO dubboMethod);
    Result getById(Long id);
    Result delete(DubboMethodDTO dubboMethodDTO);
    Result updateStatus(DubboMethodDTO dubboMethodDTO);
}
