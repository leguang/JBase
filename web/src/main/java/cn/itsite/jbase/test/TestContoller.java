package cn.itsite.jbase.test;

import cn.itsite.jbase.common.base.BaseResponse;
import cn.itsite.jbase.exception.MyException;
import cn.itsite.jbase.model.mapper.DictItemMapper;
import cn.itsite.jbase.model.pojo.DictItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController        // @RestController = @Controller + @ResponseBody
public class TestContoller {
    private static final Logger logger = LoggerFactory.getLogger(TestContoller.class);

    @Autowired
    private DictItemMapper dictItemMapper;

    @RequestMapping("/test")
    public BaseResponse<List<DictItem>> getUser() throws MyException {
//        int i = 1 / 0;

//        throw new MyException();
        List<DictItem> dictItems = dictItemMapper.selectAll();
//        return "{\n" +
//                "    \"test\": \"test\"\n" +
//                "}";

        for (DictItem dictItem : dictItems) {
            logger.debug(dictItem.toString());
            System.out.println(dictItem.toString());
        }


        return BaseResponse.success(dictItems);
    }
}
