package com.example.tempmon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller//
public class TempRefrController {
    @Autowired
    AvrTransferWin tem;


    @RequestMapping("/reft")
    public String home(Map<String, Object> model) throws Exception {
        tem.opendiv();
        tem.proxyread();
        model.put("temperature", tem.res);
        return "graph";
    }
}
