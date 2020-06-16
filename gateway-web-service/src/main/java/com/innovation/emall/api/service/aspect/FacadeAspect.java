package com.innovation.emall.api.service.aspect;

import com.innnovation.emall.common.api.JsonResVo;
import com.innnovation.emall.common.api.enums.ErrorEnum;
import com.innovation.emall.common.web.exception.BizException;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 服务端Facade 拦截器
 *
 * @author tian.tian
 * @date 2018/12/28 14:21
 */
@Component
@Aspect
public class FacadeAspect {

    private final static Logger log = LoggerFactory.getLogger(FacadeAspect.class);

    @Pointcut("execution(* com.innovation.emall..*Controller.*(..)))")
    public void getMethod() {

    }

    @Around("getMethod()")
    public Object doAround(ProceedingJoinPoint call) throws Throwable {
        MethodSignature signature = (MethodSignature) call.getSignature();
        Method method = signature.getMethod();
        String[] classNameArray = method.getDeclaringClass().getName().split("\\.");
        String methodName = classNameArray[classNameArray.length - 1] + "." + method.getName();
        String params = buildParamsDefault(call);
        JsonResVo baseRes = null;
        Date startDate = new Date();
        try {
//            buildLoginInfo(call, method.getAnnotation(ValidToken.class));
            log.info("[SERVICE_REQUEST]" + methodName + "," + params);
            baseRes =  (JsonResVo) call.proceed();
            log.info("[SERVICE_RESPONSE]" + ToStringBuilder.reflectionToString(baseRes, ToStringStyle.SHORT_PREFIX_STYLE));
            return baseRes;
        } catch (BizException e) {
            if(baseRes==null){
                baseRes = new JsonResVo();
            }
            if (e.getErrorCode() != null) {
                baseRes.setCode(Integer.parseInt(e.getErrorCode()));
            } else {
                baseRes.setCode(ErrorEnum.ERROR_BIZ_FAIL.getErrorCode());
            }
            baseRes.setErrmsg(e.getMessage());
            log.error("业务处理异常", e);
            return baseRes;
        } catch (Exception e) {
            if(baseRes==null){
                baseRes = new JsonResVo();
            }
            baseRes.setCode(ErrorEnum.SYSTEM_ERROR.getErrorCode());
            baseRes.setErrmsg(ErrorEnum.SYSTEM_ERROR.getErrorMessage());
            log.error("未知异常: " + e.getMessage(), e);
            return baseRes;
        } finally {
            if(baseRes==null){
                baseRes = new JsonResVo();
            }
            log.info("[SERVICE_RESPONSE]" + methodName + "," + baseRes);
            long runTimes = System.currentTimeMillis() - startDate.getTime();
            log.info(methodName + "," + baseRes.getCode() + "," + runTimes + "ms");
        }
    }


//    /**
//     * 统一获取登录信息
//     */
//    private void buildLoginInfo(ProceedingJoinPoint call, ValidToken annotation) {
//        if (call.getArgs() != null) {
//            for (int i = 0, size = call.getArgs().length; i < size; i++) {
//                Object obj = call.getArgs()[i];
//                if (obj instanceof BaseBo) {
//                    String token = ((BaseBo) obj).getToken();
//                    if (annotation == null || annotation.check()) {
//                        UserVo userVo = JwtUtil.getUserVoByToken(token);
//                        SessionHelper.getInstance().setUserVo(userVo);
//                    }
//                    return;
//                }
//            }
//        }
//    }

    private String buildParamsDefault(ProceedingJoinPoint call) {
        String params = "[";
        for (int i = 0; i < call.getArgs().length; i++) {
            Object obj = call.getArgs()[i];
            if (i != call.getArgs().length - 1) {
                params += obj + ",";
            } else {
                params += obj + "]";
            }
        }
        return params;
    }
}
