package com.innovation.gateway.system.provider.mapper;

import com.innovation.gateway.system.provider.entity.DubboMethod;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DubboMethodMapper {
    int insert(DubboMethod dubboMethod);
    List<DubboMethod> getList(DubboMethod dubboMethod);
    DubboMethod getById(Long id);
    DubboMethod getUrl(@Param("url") String url);
    int updateDeleteStatus(DubboMethod dubboMethod);
    int updateStatus(DubboMethod dubboMethod);

}
