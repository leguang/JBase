package cn.itsite.jbase.common.base;

import cn.itsite.jbase.common.helper.JsonHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> implements Serializable {
    public static final Integer SUCCESS = 200;//成功
    public static final Integer LOGOUT = -456;//登出、注销、账户在其他地方登录
    public static final Integer MISSING_PARAMS = -401;//参数缺失：具体看message提示
    public static final Integer PARAMS_ERROR = -402;//非法参数：可能是格式不对，可能是类型不对，具体看message提示
    public static final Integer REPEAT_ERROR = -409;//重复请求，如：验证码[10]分钟内有效
    public static final Integer UNKNOW_ERROR = -1;//未知错误

    private static final Logger logger = LoggerFactory.getLogger(BaseResponse.class);

    public Integer code;
    public String message;
    public Integer page;
    public Integer pageSize;
    public String first;
    public String next;
    public String previous;
    public String last;
    public T data;

    public BaseResponse(Response response) {
        this.code = response.getCode();
        this.message = response.getMessage();
    }

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(BaseResponse<T> response) {
        this.code = response.code;
        this.message = response.message;
        this.data = response.data;
        this.page = response.page;
        this.pageSize = response.pageSize;
        this.first = response.first;
        this.next = response.next;
        this.previous = response.previous;
        this.last = response.last;
    }

    public BaseResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @JsonIgnore
    public Boolean isSuccessful() {
        return Objects.equals(code, SUCCESS);
    }

    @JsonIgnore
    public Boolean isLogout() {
        return Objects.equals(code, LOGOUT);
    }

    public Integer getCode() {
        return code;
    }

    public BaseResponse<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Integer getPage() {
        return page;
    }

    public BaseResponse<T> setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public BaseResponse<T> setPageSize(Integer pageSize) {
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
        String json = JsonHelper.object2String(this);
        logger.debug("json-->" + json);
        return json;
    }

    public BaseResponse<T> newBuilder() {
        return new BaseResponse<T>(this);
    }

    public static BaseResponse success() {
        return success(null);
    }

    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> response = new BaseResponse<>(SUCCESS, "success");
        response.setData(data);
        return response;
    }

    public static BaseResponse error(Integer code, String message) {
        return new BaseResponse(code, message);
    }

    public static <T> BaseResponse<T> error(Integer code, String message, T data) {
        return new BaseResponse<T>(code, message, data);
    }

    public static BaseResponse error(Response response) {
        return new BaseResponse(response);
    }

    public static BaseResponse errorLogout() {
        return new BaseResponse(LOGOUT, "恭喜你退出登录了");
    }

    /**
     * 这里要想办法考虑国际化的问题，还是得弄到配置里去
     */
    public enum Response {
        SUCCESS(200, "成功"),
        LOGOUT(-456, "登出、注销、账户在其他地方登录"),
        MISSING_PARAMS(-401, "参数缺失：具体看message提示"),
        PARAMS_ERROR(-402, "非法参数"),
        REPEAT_ERROR(-409, "重复请求"),
        UNKNOW_ERROR(-1, "未知错误");

        private Integer code;
        private String message;

        Response(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
