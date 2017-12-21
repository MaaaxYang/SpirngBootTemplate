package com.ryan.atom.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/21.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
    public String getUser()
    {
        return "i'm user test";
    }

    @RequestMapping("/logout")
    public String logout()
    {
        return "logout";
    }

    @RequestMapping("/login")
    public String login()
    {
        return "pleese login";
    }

    @RequestMapping("/403")
    public String noPermission()
    {
        return "403 - noPermission";
    }

    @RequestMapping("/permissionY")
    @RequiresPermissions("权限添加")
    public String permissionY()
    {
        return "permission - 权限添加";
    }

    @RequestMapping("/permissionN")
    @RequiresPermissions("权限添加2")
    public String permissionN()
    {
        return "permission - 权限添加2";
    }
}
