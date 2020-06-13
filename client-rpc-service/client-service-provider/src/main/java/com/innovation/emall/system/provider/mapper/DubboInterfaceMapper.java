package com.innovation.emall.system.provider.mapper;

import com.innovation.emall.system.provider.entity.DubboInterface;

import java.util.List;


public interface DubboInterfaceMapper {
    int insert(DubboInterface dubboInterface);
    List<DubboInterface> getList();
    DubboInterface getUrl(DubboInterface dubboInterface);
    int updateInterface(DubboInterface dubboInterface);
    int deleteInterface(DubboInterface dubboInterface);
    int enableOrDisable(DubboInterface dubboInterface);
    DubboInterface getById(Long id);
}
