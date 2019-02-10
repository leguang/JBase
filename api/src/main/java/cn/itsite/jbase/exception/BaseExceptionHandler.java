package cn.itsite.jbase.exception;

import cn.itsite.jbase.common.base.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object errorHandler(HttpServletRequest reqest, HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        ExceptionHelper.handle(e);
        BaseResponse baseResponse = BaseResponse.error(BaseResponse.UNKNOW_ERROR, e.getMessage());
        if (e instanceof MyException) {
            baseResponse = BaseResponse.error(BaseResponse.Response.PARAMS_ERROR);
        } else {
            baseResponse = BaseResponse.error(-1, e.getMessage(), e);
        }
        return baseResponse;
    }
}
