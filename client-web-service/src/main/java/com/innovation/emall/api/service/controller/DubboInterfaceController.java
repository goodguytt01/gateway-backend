package com.innovation.emall.api.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.innnovation.emall.common.api.BaseBo;
import com.innnovation.emall.common.api.JsonResVo;
import com.innovation.emall.system.api.entity.DubboInterfaceDTO;
import com.innovation.emall.system.api.service.DubboInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/Dubbo")
public class DubboInterfaceController {

    @Reference
    private DubboInterfaceService dubboInterfaceService;


    @RequestMapping(method =  {RequestMethod.POST},value = "/Interface/Add")
    @ResponseBody
    public JsonResVo addPropertyKey(@RequestBody BaseBo<DubboInterfaceDTO> interfaceDTO) {
        dubboInterfaceService.insert(interfaceDTO.getParams());
        return JsonResVo.buildSuccess();
    }

    @RequestMapping(method =  {RequestMethod.GET},value = "/Interface/List")
    @ResponseBody
    public JsonResVo addPropertyKey() {
        return JsonResVo.buildSuccess(dubboInterfaceService.getList());
    }

    @RequestMapping(method =  {RequestMethod.GET},value = "/Interface")
    @ResponseBody
    public JsonResVo addPropertyKey(Long id) {
        return JsonResVo.buildSuccess(dubboInterfaceService.getById(id));
    }



    @RequestMapping(method =  {RequestMethod.POST},value = "/Interface/Edit")
    @ResponseBody
    public JsonResVo editInterface(@RequestBody DubboInterfaceDTO dubboInterfaceDTO) {
        return JsonResVo.buildSuccess(dubboInterfaceService.enableOrDisable(dubboInterfaceDTO));
    }

    @RequestMapping(method =  {RequestMethod.POST},value = "/Interface/Delete")
    @ResponseBody
    public JsonResVo deleteInterface(@RequestBody DubboInterfaceDTO dubboInterfaceDTO) {
        return JsonResVo.buildSuccess(dubboInterfaceService.deleteInterface(dubboInterfaceDTO));
    }


    @RequestMapping(method =  {RequestMethod.POST},value = "/Interface/Status")
    @ResponseBody
    public JsonResVo statusInterface(@RequestBody DubboInterfaceDTO dubboInterfaceDTO) {
        return JsonResVo.buildSuccess(dubboInterfaceService.enableOrDisable(dubboInterfaceDTO));
    }
}
