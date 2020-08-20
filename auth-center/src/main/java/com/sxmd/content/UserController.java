package com.sxmd.content;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author cy
 * @date 2020年08月20日 11:14
 * Version 1.0
 */
@RestController
public class UserController {


    @GetMapping("/my/login")
    public String test() {
        return "test";
    }

}
