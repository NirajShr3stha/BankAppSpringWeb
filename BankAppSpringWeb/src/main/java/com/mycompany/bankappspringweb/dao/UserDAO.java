/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bankappspringweb.dao;

import com.mycompany.bankappspringweb.domain.Users;

/**
 *
 * @author Niraj Shrestha
 */
public interface UserDAO {
    public boolean login(String userName, String passWord);
    public boolean addUser(String userName,String passWord);
    public Users findUser(String userName);
    public boolean deleteUser(String userName);
    
}
