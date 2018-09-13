package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/login")
@Controller
public class LoginController {
    @RequestMapping("/login.do")
    public ModelAndView login(String name, String password, ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {
        if (name.length()==0||password.length()==0){
            mav.setViewName("error");
        }
        else {
            mav.setViewName("login");
            request.getSession().setAttribute("user","zhangsan");
        }
        return mav;
    }
}
