package cn.itsite.jbase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController        // @RestController = @Controller + @ResponseBody
public class TestContoller {

    @RequestMapping("/test")
    public String getUser() {


        return "{\n" +
                "    \"test\": \"test\"\n" +
                "}";
    }
}
