package cn.itsite.jbase;

import cn.itsite.jbase.dao.mapper.DictItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JBaseApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(JBaseApplicationTests.class);

    @Autowired
    private DictItemMapper dictItemMapper;


    @Test
    public void contextLoads() {

        String s = UUID.randomUUID().toString().replace("-", "");
        System.out.println("UUID-->" + s);
        char[] chars = s.toCharArray();
        byte[] bytes = s.getBytes();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(aByte);
        }
        System.out.println("stringBuilder-->" + stringBuilder.toString());


//        List<DictItem> dictItems = dictItemMapper.selectAll();
//        for (DictItem dictItem : dictItems) {
//            logger.debug(dictItem.toString());
//
//        }

    }

}
