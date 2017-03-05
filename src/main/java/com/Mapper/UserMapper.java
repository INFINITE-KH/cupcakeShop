package com.Mapper;

import com.DB.DBConnector;
import com.Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper
{

    Connection conn;

    public UserMapper()
    {
        this.conn = new DBConnector().getConnection();
    }
    
    public void updateUser(User user) throws SQLException
    {
               try
        {
            String sql = "UPDATE user SET balance=? WHERE username=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(2, user.getUsername());
            pstm.setDouble(1, user.getBalance());
            
            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException ex)
          {
           System.out.println(ex);
          }
    }

    public User createUser(User user) throws SQLException
    {
        try
        {
            String sql = "SELECT * FROM user WHERE username=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
            {
                return null;
            }

            int hashPassword = user.getPassword().hashCode();
            String hashString = String.valueOf(hashPassword);
            System.out.println(hashString);
            sql = "INSERT INTO user(username, password, balance) VALUES(?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, hashString);
            pstmt.setDouble(3, user.getBalance());
            pstmt.executeUpdate();

            return user;

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public User getUser(User user)
    {

        try
        {
            int hashPassword = user.getPassword().hashCode();
            String hashString = String.valueOf(hashPassword);
            String sql = "SELECT * FROM user WHERE username=? and password=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, hashString);
            ResultSet rs = pstm.executeQuery();
            if (rs.next())
            {
             double balance = rs.getDouble("balance");
             user = new User(user.getUsername(), balance);
            }

        } catch (SQLException ex)
          {
           System.out.println(ex);
          }
        return user;
    }

    public static void main(String[] args)
    {
        try
        {
            UserMapper um = new UserMapper();
            User user = new User("Ali", "1234", 100.00);
            um.createUser(user);
        } catch (SQLException ex)
        {
            Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
