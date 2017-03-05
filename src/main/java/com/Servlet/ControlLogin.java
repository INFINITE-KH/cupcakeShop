package com.Servlet;

import com.Entity.Bottoms;
import com.Entity.Toppings;
import com.Entity.User;
import com.Mapper.BottomsMapper;
import com.Mapper.ToppingsMapper;
import com.Mapper.UserMapper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControlLogin", urlPatterns =
{
    "/ControlLogin"
})
public class ControlLogin extends HttpServlet
{
    public User u1;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {
        
        String username, password;
        double balance = 0.00;
        boolean loggedIn = false;
        
        if (!loggedIn)
        {
         username = request.getParameter("username");
         password = request.getParameter("password");
         
         UserMapper um = new UserMapper();
         User u = new User(username, password);
         u1 = um.getUser(u);
         balance = u1.getBalance();
         
        BottomsMapper bm = new BottomsMapper();
        request.getSession().setAttribute("bottom", bm.getBottoms());
        ArrayList<Bottoms> liste = (ArrayList<Bottoms>)request.getSession().getAttribute("bottom");
        
        ToppingsMapper tm = new ToppingsMapper();
        request.getSession().setAttribute("topping", tm.getToppings());
        request.getSession().setAttribute("cupcakestatus", "Status: None");
        request.getSession().setAttribute("status", "Status: Amount must be from 20 to 100");
        request.getSession().setAttribute("username", username);
        request.getSession().setAttribute("password", password);
        request.getSession().setAttribute("balance", balance);
         if(password.equals(u1.getPassword()) && username.equals(u1.getUsername())){
             
         request.getRequestDispatcher("Login.jsp").forward(request, response);
             
         } else {
             
         request.getRequestDispatcher("View.jsp").forward(request, response);
             
         }
        }    

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        } catch (SQLException ex)
        {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        } catch (SQLException ex)
        {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
}
