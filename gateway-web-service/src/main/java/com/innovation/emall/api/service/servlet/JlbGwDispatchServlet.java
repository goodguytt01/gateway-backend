package com.innovation.emall.api.service.servlet ;

import com.alibaba.dubbo.rpc.service.GenericService;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

import com.innovation.emall.api.service.manager.DubboInterfaceManager;
import com.innovation.emall.api.service.manager.DubboMethodManager;
import com.innovation.emall.api.service.servlet.utils.DubboUtil;
import com.innovation.emall.api.service.servlet.utils.HttpServletUtil;
import com.innovation.emall.system.api.entity.DubboInterfaceDTO;
import com.innovation.emall.system.api.entity.DubboMethodDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
@WebServlet(name = "jlbGwDispatchServlet", urlPatterns = "/api/dubbo/*")
public class JlbGwDispatchServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(JlbGwDispatchServlet.class);

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime()))
            .create();




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("GET the request uri [{}]", req.getRequestURI());
        }
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        DubboInterfaceManager dubboInterfaceManager = (DubboInterfaceManager)context.getBean("dubboInterfaceManager");
        // 分段获取jlbApi标签配置的domain和url值
        DubboMethodDTO apiInfoResult = getApiInfo(req, resp);
        DubboInterfaceDTO interfaceDTO = dubboInterfaceManager.getById(apiInfoResult.getInterfaceId());
        if ( apiInfoResult == null) {
            // 如果接口不存在（未上报).返回-99 errorCode.
            Map<String, String> result = new HashMap<>();
            result.put("code", "11000001");
            result.put("msg", "访问接口不存在");
            result.put("data", null);
            writeResponse(resp, result);
            return;
        }
        // 如果需要登录则从会话中获取用户ID
        // 根据查询到的接口信息配置泛化的接口信息。
        DubboUtil dubboUtil = new DubboUtil();
        // 获取前端传递参数列表
        Map<String, String> parameters = HttpServletUtil.getReqParasGet(req);
        GenericService genericService = dubboUtil.getGenericService(interfaceDTO);
        Object result = dubboUtil.genericCallRpc(genericService, apiInfoResult, parameters);
        writeResponse(resp, result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("POST the request uri [{}]", req.getRequestURI());
        }
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        DubboInterfaceManager dubboInterfaceManager = (DubboInterfaceManager)context.getBean("dubboInterfaceManager");
        // 分段获取jlbApi标签配置的domain和url值
        DubboMethodDTO apiInfoResult = getApiInfo(req, resp);
        // 根据查询到的接口信息配置泛化的接口信息。
        DubboUtil dubboUtil = new DubboUtil();
        DubboInterfaceDTO interfaceDTO = dubboInterfaceManager.getById(apiInfoResult.getInterfaceId());
        GenericService genericService = dubboUtil.getGenericService(interfaceDTO);
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String temp;
        while ((temp = br.readLine()) != null) {
            sb.append(temp);
        }
        Map<String, String> reqParameters = new HashMap<>();
        if (!StringUtils.isEmpty(sb.toString())) {
            reqParameters = JSON.parseObject(sb.toString(), Map.class);
        }
        String finalValue = "";
        if (dubboUtil.isObject(apiInfoResult.getParameterType())) {
            finalValue = "{ '" + apiInfoResult.getParameterName() + "':" + sb + "}";
        }
        if (!StringUtils.isEmpty(finalValue)) {
            reqParameters = JSON.parseObject(finalValue, Map.class);
        }
        Object result = dubboUtil.genericCallRpc(genericService, apiInfoResult, reqParameters);
        writeResponse(resp, result);
    }

    private DubboMethodDTO getApiInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] urlParas = HttpServletUtil.getUrlPath(req);
        DubboMethodDTO apiInfoDTO = new DubboMethodDTO();
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        DubboMethodManager dubboMethodManager = (DubboMethodManager)context.getBean("dubboMethodManager");
        // 分段获取jlbApi标签配置的domain和url值
        return dubboMethodManager.getByUrl(urlParas[1]);
        // 查询domain和url值对应的接口信息
    }






    private void writeResponse(HttpServletResponse resp, Object data) throws IOException {
        resp.setContentType("text/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String json = GSON.toJson(data);
        out.println(json);
        out.flush();
        out.close();
    }




}


