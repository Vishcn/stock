package com.vishcn.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p/>
 * Project: javawebTemplate <br>
 * Package com.vishcn.controller.api <br>
 * Description: <br>
 * DATE 15/5/14 18:58 <br>
 *
 * @author Vishcn<br>
 * @version V1.0 <br>
 */
@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("t")
    public String test(){
        System.out.println("TEST");
        return "/index.jsp";
    }

}
