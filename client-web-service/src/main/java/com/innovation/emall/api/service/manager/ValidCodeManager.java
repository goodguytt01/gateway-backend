package com.innovation.emall.api.service.manager;

import com.innovation.emall.system.api.entity.ClientDTO;

public interface ValidCodeManager {
    public void sendValidCode(ClientDTO clientDTO);
}
