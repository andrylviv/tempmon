package com.tempmon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TempRefrController {


    @RequestMapping("/tempmon")
    public String home()  {
        return "graph";
    }
}
