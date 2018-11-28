package cn.itsite.jbase;

import cn.itsite.jbase.model.mapper.DictItemMapper;
import cn.itsite.jbase.model.pojo.DictItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JBaseApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(JBaseApplicationTests.class);

    @Autowired
    private DictItemMapper dictItemMapper;


    @Test
    public void contextLoads() {

        List<DictItem> dictItems = dictItemMapper.selectAll();
        for (DictItem dictItem : dictItems) {
            logger.debug(dictItem.toString());

        }

    }

}
