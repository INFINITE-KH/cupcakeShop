package com.Mapper;

import com.DB.DBConnector;
import com.Entity.Toppings;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ToppingsMapper
{

    Connection conn;

    public ToppingsMapper()
    {
        this.conn = new DBConnector().getConnection();
    }

    public ArrayList<Toppings> getToppings() throws SQLException
    {
        ArrayList<Toppings> toppings = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM toppings";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next())
            {
                String tp = rs.getString("topping");
                double price = rs.getDouble("price");
                Toppings topping = new Toppings(tp, price);
                toppings.add(topping);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return toppings;
    }

    public static void main(String[] args)
    {
        try
        {
            ToppingsMapper tp = new ToppingsMapper();
            ArrayList<Toppings> toppings = new ArrayList<>();
            
            toppings = tp.getToppings();
            
            for (Toppings topping : toppings)
            {
                System.out.println(topping.getTopping() + " " + topping.getPrice());
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
