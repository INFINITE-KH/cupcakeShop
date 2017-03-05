package com.Mapper;

import com.DB.DBConnector;
import com.Entity.Bottoms;
import com.Entity.Toppings;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BottomsMapper
{

    Connection conn;

    public BottomsMapper()
    {
        this.conn = new DBConnector().getConnection();
    }

    public ArrayList<Bottoms> getBottoms() throws SQLException
    {

        ArrayList<Bottoms> bottoms = new ArrayList<>();
        try
        {
            String sql = "SELECT * FROM bottoms";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next())
            {
                String bt = rs.getString("bottom");
                double price = rs.getDouble("price");
                Bottoms bottom = new Bottoms(bt, price);
                bottoms.add(bottom);
            }
        } 
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return bottoms;

    }
    
        public static void main(String[] args)
    {
        try
        {
            BottomsMapper bp = new BottomsMapper();
            ArrayList<Bottoms> toppings = new ArrayList<>();
            
            toppings = bp.getBottoms();
            
            for (Bottoms topping : toppings)
            {
                System.out.println(topping.getBottom()+ " " + topping.getPrice());
            }
        }catch(Exception e){
            
        }
    }

}
