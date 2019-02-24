package cn.itsite.jbase.test;

import cn.itsite.jbase.common.test.User;
import cn.itsite.jbase.entity.DictItem;
import cn.itsite.jbase.entity.SysUser;
import cn.itsite.jbase.mapper.DictItemMapper;
import cn.itsite.jbase.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    public SysUserMapper sysUserMapper;

    @Override
    public SysUser getUser(@Validated User user) {
        /**
         * 0.校验参数，只需要调用下面这一行代码即可，
         * 如果有异常会在全局异常那里捕获到，并作出参数错误的特定响应
         */
//        ValidatorHelper.validate(user);
        /**
         * 1.调用 dao 层完成业务逻辑
         */
        SysUser user1 = sysUserMapper.selectByPrimaryKey(user.getName());
        /**
         * 2.做相关处理并返回相应数据
         */
//        User user1 = new User();
//        user1.setAge(11);
//        user1.setGender("111");
//        user1.setName("222");
        return user1;
    }
}