package com.innovation.emall.system.provider.mapper;

import com.innovation.emall.system.provider.entity.Area;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AreaMapper extends Mapper<Area> {
    List<Area> getProvinces(Integer provinceId);
}