package cn.itsite.jbase.test;

import cn.itsite.jbase.exception.MyException;
import cn.itsite.jbase.pojo.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {
    private static final Logger logger = LoggerFactory.getLogger(TestContoller.class);


    @RequestMapping("/test")
    public Resource getUser() throws MyException {
////        int i = 1 / 0;
//
////        throw new MyException();
//        List<DictItem> dictItems = dictItemMapper.selectAll();
//         for (DictItem dictItem : dictItems) {
//            logger.debug(dictItem.toString());
//            System.out.println(dictItem.toString());
//        }
        Resource resource = new Resource();
        resource.setTest("11111111");
        return resource;
//        return new ResponseEntity("11", HttpStatus.CREATED);
    }


    public static void main(String[] args) {
        byte value = -1;
//        String bs = String.format("%8s", Integer.toBinaryString(value));
        String bs = String.format("%8s", Integer.toBinaryString(value & 0xFF)).replace(" ", "0");
        System.out.println(Integer.toBinaryString(value));
    }
}
