package com.sdzy.www.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/adminpage")
    public String getadmin(){
        return "admin/admin";
    }
}


