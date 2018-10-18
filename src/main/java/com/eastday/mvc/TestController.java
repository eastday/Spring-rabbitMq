package com.eastday.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

     @RequestMapping("/hello")
     @ResponseBody
     public  String  hello(@RequestParam  String name){

         return   "hello "+name;
     }
}
