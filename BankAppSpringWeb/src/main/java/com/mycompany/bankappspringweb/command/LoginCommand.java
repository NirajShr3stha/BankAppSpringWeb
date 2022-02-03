/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankappspringweb.command;

/**
 *
 * @author Niraj Shrestha
 */
public class LoginCommand {
    private String uName; //same name from login.jsp
    private String pWord;

    public LoginCommand(String uName, String pWord) {
        this.uName = uName;
        this.pWord = pWord;
    }

    public LoginCommand() {
        
    }
    
    public String getuName() {
        return uName;
    }

    public String getpWord() {
        return pWord;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setpWord(String pWord) {
        this.pWord = pWord;
    }
    
}
