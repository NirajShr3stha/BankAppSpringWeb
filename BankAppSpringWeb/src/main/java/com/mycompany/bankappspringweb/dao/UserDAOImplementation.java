/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankappspringweb.dao;

import static com.mycompany.bankappspringweb.dao.DatabaseVariable.db;
import com.mycompany.bankappspringweb.domain.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Niraj Shrestha
 */
@Repository
public class UserDAOImplementation implements UserDAO {

    @Override
    public boolean login(String userName, String passWord) {
        String sql = "select * from dbbank.users";
        ResultSet rs = db.select(sql);
        try {
            while (rs.next()) {
                Users us = new Users(rs.getString(1), rs.getString(2));
                if ((us.getUserName().equals(userName)) && (us.getPassWord().equals(passWord))) {
                    return true;
                }
            }
        } catch (SQLException e) {
            return false;
        }

        if ((userName.equals("admin")) && (passWord.equals("admin"))) {
            return true;
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addUser(String userName, String passWord) {
        if (findUser(userName) == null) {
            String sql = "INSERT INTO `dbbank`.`users` (`userName`, `passWord`) VALUES ('" + userName + "', '" + passWord + "');";
            return db.iud(sql);
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users findUser(String userName) {
        String sql = "select * from dbbank.users where userName=\"" + userName + "\";";
        ResultSet rs = db.select(sql);
        try {
            while (rs.next()) {
                Users us = new Users(rs.getString(1), rs.getString(2));
                return us;
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteUser(String userName) {
        if (findUser(userName) != null) {

            String sql = "DELETE FROM dbbank.users WHERE userName='" + userName + "';";
            return db.iud(sql);
        }
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
