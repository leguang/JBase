package cn.itsite.jbase.test;

import cn.itsite.jbase.common.helper.ValidatorHelper;
import cn.itsite.jbase.common.test.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    public TestMapper testMapper;

    @Override
    public User getUser(User user) {
        /**
         * 0.校验参数，只需要调用下面这一行代码即可，
         * 如果有异常会在全局异常那里捕获到，并作出参数错误的特定响应
         */
        ValidatorHelper.validate(user);
        /**
         * 1.调用 dao 层完成业务逻辑
         */
        User user1 = testMapper.selectByPrimaryKey(user.getName());
        /**
         * 2.做相关处理并返回相应数据
         */
        return user1;
    }
}