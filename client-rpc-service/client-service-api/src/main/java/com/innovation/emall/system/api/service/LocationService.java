package com.innovation.emall.system.api.service;

import com.innnovation.emall.common.api.Result;

public interface LocationService {
    Result getLocations(Long parentId);
    Result getLocationById(Integer id);
}
