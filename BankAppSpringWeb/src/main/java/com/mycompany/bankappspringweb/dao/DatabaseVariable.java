/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bankappspringweb.dao;

import com.mycompany.bankappspringweb.controller.DbConnection;

/**
 *
 * @author Niraj Shrestha
 */
public interface DatabaseVariable {
    public static DbConnection db = new DbConnection();
}
