package com.sxmd.base;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Description:  自定义用户类
 *
 * @author cy
 * @date 2020年08月18日 18:25
 * Version 1.0
 */
public class CustomUser extends User {

    private Long id;

    private static final long serialVersionUID = 2211650299625150878L;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
