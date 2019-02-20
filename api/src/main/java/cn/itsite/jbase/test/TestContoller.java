package cn.itsite.jbase.test;

import cn.itsite.jbase.common.base.BaseResponse;
import cn.itsite.jbase.common.helper.ValidatorHelper;
import cn.itsite.jbase.common.test.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class TestContoller {
    @Autowired
    public TestService testService;

    @GetMapping("/test")
    public BaseResponse getUser(@Valid User user, BindingResult result) {
        /**
         * 0.校验参数，只需要调用下面这一行代码即可，
         * 如果有异常会在全局异常那里捕获到，并作出参数错误的特定响应。
         */
        ValidatorHelper.validate(result);
        /**
         * 1.调用service层完成业务逻辑
         */
        User user1 = testService.getUser(user);
        /**
         * 2.拼装统一的响应对象
         */
        return BaseResponse.success(user1);
    }
}
