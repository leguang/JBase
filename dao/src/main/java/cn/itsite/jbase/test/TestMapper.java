package cn.itsite.jbase.test;


import cn.itsite.jbase.common.test.User;
import cn.itsite.jbase.entity.DictItem;

import java.util.List;


public interface TestMapper {
    int deleteByPrimaryKey(String uid);

    int insert(DictItem record);

    User selectByPrimaryKey(String uid);

    List<DictItem> selectAll();

    int updateByPrimaryKey(DictItem record);
}