package com.innovation.emall.system.api.service;

import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.DubboInterfaceDTO;

import java.util.List;

public interface DubboInterfaceService {
    Result insert(DubboInterfaceDTO dubboInterface);
    Result getList();
    Result getUrl(DubboInterfaceDTO dubboInterface);
    Result updateInterface(DubboInterfaceDTO dubboInterface);
    Result deleteInterface(DubboInterfaceDTO dubboInterface);
    Result enableOrDisable(DubboInterfaceDTO dubboInterface);
    Result getById(Long id);

}
