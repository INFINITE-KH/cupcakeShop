package com.Entity;

public class Toppings
{
 String topping;
 double price;

    public Toppings(String topping, double price)
    {
        this.topping = topping;
        this.price = price;
    }

    public Toppings()
    {
        
    }        
    
    public String getTopping()
    {
        return topping;
    }

    public void setTopping(String topping)
    {
        this.topping = topping;
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
        return "Toppings{" + "topping=" + topping + ", price=" + price + '}';
    }
 
}
