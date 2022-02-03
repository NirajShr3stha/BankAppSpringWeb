/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankappspringweb.controller;

import com.mycompany.bankappspringweb.command.LoginCommand;
import com.mycompany.bankappspringweb.dao.UserDAO;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Niraj Shrestha
 */
@Controller
public class UserController {
    @Autowired
    UserDAO ud;
    
    @RequestMapping(value={"/","/login"})
    public String LoginForm(Model m, HttpSession session){
        m.addAttribute("command", new LoginCommand()); //commands from login.jsp
        session.invalidate();
        return "login";
    }
    
    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public String loginProcess(@ModelAttribute("command") LoginCommand lc, Model m, HttpSession session)
    {
        if(ud.login(lc.getuName(), lc.getpWord())){
            session.setAttribute("uName", lc.getuName());
            return "redirect:dashboard";
        }
        else{
            m.addAttribute("message", "Invalid Login details");
            return "login";
        }
    }
    
    //open dashboard function
    @RequestMapping("/dashboard")
    public String dash(Model m, HttpSession session){
        if(session.getAttribute("uName")!= null)
        {
            m.addAttribute("title", "Bank Application");
            m.addAttribute("message", "Login successful");
            return "dashboard";
        }
        else
        {
            return "redirect:login";
        }
    }
    
    //logout button function
    @RequestMapping("/logout")
    public String logout(){
        return "redirect:login";
    }
    
    
}
