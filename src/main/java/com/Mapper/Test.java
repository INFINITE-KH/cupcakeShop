/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Mapper;

import com.Entity.Bottoms;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author KH
 */
public class Test
{
 public static void main(String[] args) throws SQLException
    {
        try
        {
            BottomsMapper bm = new BottomsMapper();
            ArrayList<Bottoms> bottoms = new ArrayList<>();

            bottoms = bm.getBottoms();

            for (Bottoms bottom : bottoms)

            {
                System.out.println(bottom.getBottom() + " " + bottom.getPrice());
            }

        } 
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }   
}
