package com.innovation.emall.api.service.controller;

import com.innnovation.emall.common.api.JsonResVo;
import com.innovation.emall.api.service.common.config.BaseZookeeper;
import com.innovation.emall.system.api.entity.ZkInfoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/Api")
public class ZkApiController {

    @RequestMapping(method =  {RequestMethod.POST},value = "/Zk/Apis")
    @ResponseBody
    public JsonResVo addPropertyKey(@RequestBody ZkInfoDTO zkInfoDTO) {
        BaseZookeeper zookeeper = new BaseZookeeper();
        List<String> children = new ArrayList<>();
        List<ZkInfoDTO> dtos = new ArrayList<>();
        try {
            zookeeper.connectZookeeper(zkInfoDTO.getZkAddr());
            children = zookeeper.getChildren("/dubbo");
            for(String child:children){
                ZkInfoDTO infoDTO = new ZkInfoDTO();
                infoDTO.setDomain(zkInfoDTO.getDomain());
                infoDTO.setInterfaceAddr(child);
                infoDTO.setZkAddr(zkInfoDTO.getZkAddr());
                dtos.add(infoDTO);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonResVo.buildSuccess(dtos);
    }
}
