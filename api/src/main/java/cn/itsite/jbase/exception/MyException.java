package cn.itsite.jbase.exception;

import cn.itsite.jbase.common.base.BaseResponse;

/**
 * @author: leguang
 * @e-mail: langmanleguang@qq.com
 * @version: v0.0.0
 * @blog: https://github.com/leguang
 * @time: 2018/11/25 0025 19:14
 * @description:
 */
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(BaseResponse.Response response) {
        super(response.getMessage());
        this.code = response.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
