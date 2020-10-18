package com.example.tempmon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class TemperatureController {
    @Autowired
    AvrTransferWin tem;

    @GetMapping("/temp")
    public Temperatureconf greetingWithJavaconfig() throws Exception {
       // tem.opendiv();
        tem.proxyread();
     //   Temperatureconf t =new Temperatureconf();
      //  double temperature = tem.getRes();
      //  t.setTemperature(temperature);
        System.out.println("==== in temp ==== "+tem.getRes());
        return new Temperatureconf(tem.getRes());
        //  return t;
    }

}
