package com.Entity;

public class User
{
 private String username;
 private String password;
 private double balance;

    public User(String username, String password, double balance)
    {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public User(String username, double balance)
    {
        this.username = username;
        this.balance = balance;
    }

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public User()
    {
        
    }        
    
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    @Override
    public String toString()
    {
        return "User{" + "username=" + username + ", password=" + password + ", balance=" + balance + '}';
    }
 
}
