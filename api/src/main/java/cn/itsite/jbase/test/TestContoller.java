package cn.itsite.jbase.test;

import cn.itsite.jbase.common.helper.ValidatorHelper;
import cn.itsite.jbase.exception.MyException;
import cn.itsite.jbase.pojo.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {
    private static final Logger logger = LoggerFactory.getLogger(TestContoller.class);


//    @RequestMapping("/test")
//    public Resource getUser(@Valid Resource , BindingResult bindingResult ) throws MyException {
////        bindingResult.hasErrors()
////        Resource resource = new Resource();
//////        resource.setTest("11111111");
////        //1. 这几行都是校验的模板代码
////        //2. 调用server
////        //3. 返回的时候拼装新dto对象，
////        return resource;
////        return new ResponseEntity("11", HttpStatus.CREATED);
//    }


    @RequestMapping("/test")
    public Resource getUser() throws MyException {
//        ValidatorHelper.validateObject()


        Resource resource = new Resource();
        String s = null;
        s.split("1");
        return resource;

    }

    public static void main(String[] args) {
        byte value = -1;
//        String bs = String.format("%8s", Integer.toBinaryString(value));
        String bs = String.format("%8s", Integer.toBinaryString(value & 0xFF)).replace(" ", "0");
        System.out.println(Integer.toBinaryString(value));
    }
}
