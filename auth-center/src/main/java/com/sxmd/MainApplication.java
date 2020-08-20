package com.sxmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:  启动类
 *
 * @author cy
 * @date 2020年08月06日 18:46
 * Version 1.0
 */
@SpringBootApplication
@RestController
//@EnableDiscoveryClient
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @RequestMapping("/index")
    public String get() {
        return "login";
    }
}
