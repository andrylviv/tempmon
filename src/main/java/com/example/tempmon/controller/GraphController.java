package com.example.tempmon.controller;
import com.example.tempmon.service.AvrTransferWin;
import org.springframework.ui.Model;
//main controller//

//@Controller
public class GraphController {
  //  @Autowired
    AvrTransferWin tem;


 //       @GetMapping("/")
        public String home(Model model) throws Exception {
            tem.opendiv();
          //  tem.proxyread(model);
            model.addAttribute("temperature", tem.res);
            //tem.closediv();
            return "graph";
        }
}