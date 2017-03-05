package com.Entity;

public class Bottoms
{
 private String bottom;
 private double price;

    public Bottoms(String bottom, double price)
    {
        this.bottom = bottom;
        this.price = price;
    }

    public Bottoms()
    {
        
    }        
    
    public String getBottom()
    {
        return bottom;
    }

    public void setBottom(String bottom)
    {
        this.bottom = bottom;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "Bottoms{" + "bottom=" + bottom + ", price=" + price + '}';
    }

}
