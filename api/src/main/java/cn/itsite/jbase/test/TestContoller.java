package cn.itsite.jbase.test;

import cn.itsite.jbase.exception.MyException;
import cn.itsite.jbase.dao.mapper.DictItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController        // @RestController = @Controller + @ResponseBody
public class TestContoller {
    private static final Logger logger = LoggerFactory.getLogger(TestContoller.class);

    @Autowired
    private DictItemMapper dictItemMapper;

    @RequestMapping("/test")
    public ResponseEntity getUser(@Valid String s) throws MyException {
////        int i = 1 / 0;
//
////        throw new MyException();
//        List<DictItem> dictItems = dictItemMapper.selectAll();
////        return "{\n" +
////                "    \"test\": \"test\"\n" +
////                "}";
//
//        for (DictItem dictItem : dictItems) {
//            logger.debug(dictItem.toString());
//            System.out.println(dictItem.toString());
//        }


        return new ResponseEntity("11", HttpStatus.CREATED);
    }



    public static void main(String[] args) {
        byte value = -1;
//        String bs = String.format("%8s", Integer.toBinaryString(value));
        String bs = String.format("%8s", Integer.toBinaryString(value&0xFF)).replace(" ", "0");
        System.out.println(Integer.toBinaryString(value));
    }
}
