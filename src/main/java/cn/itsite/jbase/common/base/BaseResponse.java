package cn.itsite.jbase.common.base;

import cn.itsite.jbase.common.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author: leguang
 * @e-mail: langmanleguang@qq.com
 * @version: v0.0.0
 * @blog: https://github.com/leguang
 * @time: 2018/11/25 0025 17:31
 * @description:
 */
public class BaseResponse<T> implements Serializable {
    public static final Integer SUCCESS = 200;//成功
    public static final Integer LOGOUT = -456;//登出、注销、账户在其他地方登录
    public static final Integer MISSING_PARAMS = -501;//参数缺失：具体看message提示
    public static final Integer ERROR_PARAMS = -402;//非法参数：可能是格式不对，可能是类型不对，具体看message提示
    public static final Integer ERROR_REPEAT = -409;//重复请求，如：验证码[10]分钟内有效

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseResponse.class);

    public Integer code;
    public Integer page;
    public Integer pageSize;
    public String first;
    public String next;
    public String previous;
    public String last;
    public String message;
    public T data;

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(BaseResponse<T> response) {
        this.code = response.code;
        this.message = response.message;
        this.page = response.page;
        this.pageSize = response.pageSize;
        this.first = response.first;
        this.next = response.next;
        this.previous = response.previous;
        this.last = response.last;
        this.data = response.data;
    }

    public boolean isSuccessful() {
        return Objects.equals(code, SUCCESS);
    }

    public boolean isLogout() {
        return Objects.equals(code, LOGOUT);
    }

    public int getCode() {
        return code;
    }

    public BaseResponse<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public int getPage() {
        return page;
    }

    public BaseResponse<T> setPage(int page) {
        this.page = page;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public BaseResponse<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getFirst() {
        return first;
    }

    public BaseResponse<T> setFirst(String first) {
        this.first = first;
        return this;
    }

    public String getNext() {
        return next;
    }

    public BaseResponse<T> setNext(String next) {
        this.next = next;
        return this;
    }

    public String getPrevious() {
        return previous;
    }

    public BaseResponse<T> setPrevious(String previous) {
        this.previous = previous;
        return this;
    }

    public String getLast() {
        return last;
    }

    public BaseResponse<T> setLast(String last) {
        this.last = last;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public BaseResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        String json = JsonHelper.objectToJson(this);
        LOGGER.debug("json-->" + json);
        return json;
    }

    public BaseResponse<T> newBuilder() {
        return new BaseResponse(this);
    }

    public static BaseResponse success() {
        return success(null);
    }

    public static BaseResponse success(Object object) {
        BaseResponse response = new BaseResponse(SUCCESS, "success");
        response.setData(object);
        return response;
    }

    public static BaseResponse error(Integer code, String message) {
        return new BaseResponse(code, message);
    }

    public static BaseResponse errorLogout() {
        return new BaseResponse(LOGOUT, "恭喜你退出登录了");
    }
}
