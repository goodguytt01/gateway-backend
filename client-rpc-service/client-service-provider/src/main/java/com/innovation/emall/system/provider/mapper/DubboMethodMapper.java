package com.innovation.emall.system.provider.mapper;

import com.innovation.emall.system.provider.entity.DubboInterface;
import com.innovation.emall.system.provider.entity.DubboMethod;
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
