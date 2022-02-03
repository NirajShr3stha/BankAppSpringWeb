/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankappspringweb.controller;

import com.mycompany.bankappspringweb.command.AccountCommand;
import com.mycompany.bankappspringweb.dao.AccountDAO;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Niraj Shrestha
 */
@Controller
public class AccountController {
    @Autowired
    AccountDAO ad;
    
    //FOR MAKING NEW ACCOUNT
    @RequestMapping("/createnewaccount")
    public String createNewAccount(Model m, HttpSession session){
        if(session.getAttribute("uName")!= null){
            m.addAttribute("account", new AccountCommand());
            return "createnewaccount";
        } 
        return "redirect:login";
    }
    
    @RequestMapping(value={"/processNewAccount"}, method=RequestMethod.POST)
    public String viewProcessNewAccount(@ModelAttribute("account") AccountCommand ac, HttpSession session)
    {
        if(session.getAttribute("uName")!= null)
        {
            if(ad.addAccount(ac.getAccountNumber(), ac.getAccountName(), ac.getAccountBalance()))
            {
                session.setAttribute("message", "Account  added sucessfully");
                return "redirect:createnewaccount";
            }
            else
            {
                session.setAttribute("message", "Error !! Account  already exists");
                return "redirect:createnewaccount";
            }
        }
        return "redirect:login";
    }
    
    //FOR WITHDAWN ACCOUNT BALANCE
    @RequestMapping("/withdraw")
    public String withdraw(Model m, HttpSession session){
        if(session.getAttribute("uName")!= null){
            m.addAttribute("account", new AccountCommand());
            return "withdraw";
        } 
        return "redirect:login";
    }
    
    @RequestMapping(value={"/processwithdraw"}, method=RequestMethod.POST)
    public String processWithdraw(@ModelAttribute("account") AccountCommand ac, HttpSession session)
    {
        int checkacc = ad.withdrawAmount(ac.getAccountNumber(), ac.getAccountBalance());
        if(session.getAttribute("uName")!= null)
        {
            if(checkacc == 1)
            {
                session.setAttribute("message", "Amount withdraw successful");
                return "redirect:withdraw";
            }
            else if(checkacc == -1)
            {
                session.setAttribute("message", "Insufficient Balance in the account");
                return "redirect:withdraw";
            }
            session.setAttribute("message", "Error !! Account doesnt exist");
            return "redirect:withdraw";   
        }
        return "redirect:login";
    }
    
    //FOR DEPOSITE ACCOUNT BALANCE
    @RequestMapping("/deposite")
    public String deposite(Model m, HttpSession session){
        if(session.getAttribute("uName")!= null){
            m.addAttribute("account", new AccountCommand());
            return "deposite";
        } 
        return "redirect:login";
    }
    
    @RequestMapping(value={"/processdeposite"}, method=RequestMethod.POST)
    public String processDeposite(@ModelAttribute("account") AccountCommand ac, HttpSession session)
    {
        if(session.getAttribute("uName")!= null)
        {
            if(ad.depositeAmount(ac.getAccountNumber(), ac.getAccountBalance())){
            session.setAttribute("message", "Amount deposited successfully");
            return "redirect:deposite";
            }
            else
            {
            session.setAttribute("message", "Error !! Account doesnt exist");
            return "redirect:deposite";   
            }
        }
        return "redirect:login";
    }
    
}
