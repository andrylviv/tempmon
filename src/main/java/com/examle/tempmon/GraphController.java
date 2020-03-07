package com.examle.tempmon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//trrgt

//@Controller//gsgr
public class GraphController {
    @Autowired
    AvrTransferWin tem;


      //  @GetMapping("/")
        public String home(Model model) throws Exception {
            tem.opendiv();
          //  tem.proxyread(model);
            model.addAttribute("temperature", tem.res);
            //tem.closediv();
            return "graph";
        }
}
