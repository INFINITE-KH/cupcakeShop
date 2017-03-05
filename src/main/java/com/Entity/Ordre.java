package com.Entity;

public class Ordre
{
 String FK_user;
 String FK_bottoms;
 String FK_toppings;

    public Ordre(String FK_user, String FK_bottoms, String FK_toppings)
    {
        this.FK_user = FK_user;
        this.FK_bottoms = FK_bottoms;
        this.FK_toppings = FK_toppings;
    }
    
    public Ordre()
    {
        
    }        

    public String getFK_user()
    {
        return FK_user;
    }

    public void setFK_user(String FK_user)
    {
        this.FK_user = FK_user;
    }

    public String getFK_bottoms()
    {
        return FK_bottoms;
    }

    public void setFK_bottoms(String FK_bottoms)
    {
        this.FK_bottoms = FK_bottoms;
    }

    public String getFK_toppings()
    {
        return FK_toppings;
    }

    public void setFK_toppings(String FK_toppings)
    {
        this.FK_toppings = FK_toppings;
    }

    @Override
    public String toString()
    {
        return "Ordre{" + "FK_user=" + FK_user + ", FK_bottoms=" + FK_bottoms + ", FK_toppings=" + FK_toppings + '}';
    }
 
}
