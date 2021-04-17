package com.ruoyi.web.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * 测试
 */

@Controller
public class Test {

    @GetMapping("/test")
    public String test() {
        return "front/test";
    }
}
