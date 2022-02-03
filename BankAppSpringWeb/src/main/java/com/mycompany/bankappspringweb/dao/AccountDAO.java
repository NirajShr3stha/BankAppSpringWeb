/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bankappspringweb.dao;

import com.mycompany.bankappspringweb.domain.Accounts;

/**
 *
 * @author Niraj Shrestha
 */
public interface AccountDAO {
    public boolean addAccount(int accountNumber, String accountName, int accountBalance);
    public Accounts findAccount(int accountNumber);
    public void checkBalance(int accountNumber);
    public boolean depositeAmount(int accountNumber, int depositeBalance);
    public int withdrawAmount(int accountNumber, int withdrawBalance);
    public int transferAmount(int senderAccountNumber, int recieverAccountNumber,int transferBalance);
}
