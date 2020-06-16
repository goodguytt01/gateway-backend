package com.innovation.emall.system.api.service;

import com.innnovation.emall.common.api.Result;
import com.innovation.emall.system.api.entity.ClientDTO;

public interface ClientService {

    Result insert(ClientDTO clientDTO);

    Result login(ClientDTO clientDTO);

    Result sendValidCode(ClientDTO clientDTO);

   Result setStatus(ClientDTO clientDTO);

}
