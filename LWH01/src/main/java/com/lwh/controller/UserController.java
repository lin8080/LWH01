package com.lwh.controller;

import com.lwh.pojo.User;
import com.lwh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

        @Autowired
        UserService userService;

        @RequestMapping("/login")
        public String elogin(HttpServletRequest request){
            String loginname = request.getParameter("name");
            String loginpass = request.getParameter("password");
            User user = new User();
            user.setUsername(loginname);
            user.setPassword(loginpass);

            User userLogin = userService.getLogin(user);
            if(userLogin!=null){
                return "success";
            }else{
                return "error";
            }
        }

    }
