package com.vishcn.controller.api.concurrent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Vishcn
 * @since 2015年12月08日
 */
@Controller
@RequestMapping("con")
public class ConController {

    @RequestMapping("add")
    @ResponseBody
    public String test(){
        System.out.println("TEST");
        return "add";
    }
}
