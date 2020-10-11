package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Z
 */
@Controller
public class AdminLoginController {
    @Resource
    private AdminService adminService;

    @RequestMapping("/")
    public  String  login_show(){
        return "login";
    }

    @RequestMapping("/main")
    public  String  main(){
        return "main";
    }

    @RequestMapping("/login_submit")
    public String login_submit(Admin admin, HttpSession session, Model model){
        Admin u = adminService.adminLogin(admin);
        if(u==null){
            model.addAttribute("err","用户名或密码错误");
            return "login";
        }
        session.setAttribute("adminUser",u);
        return "index";
    }

    /*@ResponseBody
    @RequestMapping("/select")
    public Object select(Admin admin){
       Admin w = new Admin();

    }*/

}
