package com.weishu.common.controller;

import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.exception.CscConfigException;
import com.weishu.common.exception.CscPacificException;
import com.weishu.common.exception.ParamsValidationException;
import com.weishu.common.vo.UnifiedResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijianye Created on 17/1/5.
 * 处理configException
 */
@RestController
public class BaseController {
    private static Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler(Throwable.class)
    public UnifiedResponse HandleAllException(Throwable e) {
        if (e instanceof CscConfigException) {
            return new UnifiedResponse(((CscConfigException) e).getCode(), e.getMessage());
        }
        else if (e instanceof ParamsValidationException) {
            return new UnifiedResponse(((ParamsValidationException) e).getCode(), e.getMessage());
        }else {
            LOGGER.error(e.toString());
            String errorMsg = e.getMessage();
            if(errorMsg != null && errorMsg.toLowerCase().contains("not present")){
                return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), ResultCodeEnum.PARAMETER_ERROR.getMsg());
            }else if(errorMsg != null && errorMsg.toLowerCase().contains("failed to convert")){
                return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR_CONVERT.getCode(), ResultCodeEnum.PARAMETER_ERROR_CONVERT.getMsg());
            }else if(errorMsg != null && errorMsg.toLowerCase().contains("is missing")){
                return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR_MISSING.getCode(), ResultCodeEnum.PARAMETER_ERROR_MISSING.getMsg());
            }else{
                return new UnifiedResponse(ResultCodeEnum.ERROR.getCode(), ResultCodeEnum.ERROR.getMsg());
            }
        }
    }
}
