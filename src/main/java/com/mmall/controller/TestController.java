package com.mmall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LR
 * @Descriprition:
 * @Date: Created in 17:21 2021/1/11
 * @Modified By:
 **/
@RestController
public class TestController {

    @RequestMapping("/t")
    public String test1(){
        return "ceshi";
    }
}
