package com.sxmd.content;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description:  登录接口
 *
 * @author cy
 * @date 2020年08月20日 10:35
 * Version 1.0
 */
@Controller
public class LoginController {

    @GetMapping("/my/oauth/authorize")
    public String authorize() {
        return "base-grant";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


}
