package com.innovation.gateway.system.provider.mapper;

import com.innovation.gateway.system.provider.entity.Area;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AreaMapper extends Mapper<Area> {
    List<Area> getProvinces(Integer provinceId);
}