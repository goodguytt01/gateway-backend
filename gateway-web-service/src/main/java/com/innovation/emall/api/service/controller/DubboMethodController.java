package com.innovation.emall.api.service.controller;

import com.innnovation.emall.common.api.BaseBo;
import com.innnovation.emall.common.api.JsonResVo;
import com.innovation.emall.api.service.manager.DubboInterfaceManager;
import com.innovation.emall.api.service.manager.DubboMethodManager;
import com.innovation.emall.system.api.entity.DubboInterfaceDTO;
import com.innovation.emall.system.api.entity.DubboMethodDTO;
import com.innovation.emall.system.api.service.DubboInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Dubbo")
public class DubboMethodController {

    @Autowired
    private DubboMethodManager dubboMethodManager;


    @RequestMapping(method =  {RequestMethod.POST},value = "/Method/Add")
    @ResponseBody
    public JsonResVo addPropertyKey(@RequestBody BaseBo<DubboMethodDTO> interfaceDTO) {
        dubboMethodManager.insert(interfaceDTO.getParams());
        return JsonResVo.buildSuccess();
    }

    @RequestMapping(method =  {RequestMethod.GET},value = "/Method/List")
    @ResponseBody
    public JsonResVo addPropertyKey(Long interfaceId) {
        DubboMethodDTO dto = new DubboMethodDTO();
        dto.setInterfaceId(interfaceId);
        return JsonResVo.buildSuccess(dubboMethodManager.getList(dto));
    }

    @RequestMapping(method =  {RequestMethod.POST},value = "/Method/Delete")
    @ResponseBody
    public JsonResVo delete(@RequestBody DubboMethodDTO interfaceDTO) {
        interfaceDTO.setDeleteFlag(true);
        dubboMethodManager.delete(interfaceDTO);
        return JsonResVo.buildSuccess();
    }

    @RequestMapping(method =  {RequestMethod.POST},value = "/Method/Status")
    @ResponseBody
    public JsonResVo updateStatus(@RequestBody DubboMethodDTO interfaceDTO) {
        dubboMethodManager.updateStatus(interfaceDTO);
        return JsonResVo.buildSuccess();
    }

    @RequestMapping(method =  {RequestMethod.GET},value = "/Method")
    @ResponseBody
    public JsonResVo getById(Long id) {
        return JsonResVo.buildSuccess(dubboMethodManager.getById(id));
    }
}
