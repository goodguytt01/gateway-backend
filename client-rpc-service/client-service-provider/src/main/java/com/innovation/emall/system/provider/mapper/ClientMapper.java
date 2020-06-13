package com.innovation.emall.system.provider.mapper;

import com.innovation.emall.system.provider.entity.Client;

public interface ClientMapper {
    int insert(Client client);
    Client loginByPassword(Client client);
    Client getByMobile(String mobile);
    int updateStatus(Client client);
}
