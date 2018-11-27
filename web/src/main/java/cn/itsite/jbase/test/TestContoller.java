package cn.itsite.jbase.test;

import cn.itsite.jbase.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController        // @RestController = @Controller + @ResponseBody
public class TestContoller {

    @RequestMapping("/test")
    public String getUser() throws MyException {
//        int i = 1 / 0;

//        throw new MyException();

        return "{\n" +
                "    \"test\": \"test\"\n" +
                "}";
    }
}
