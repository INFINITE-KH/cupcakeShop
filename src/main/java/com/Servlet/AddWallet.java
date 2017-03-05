package com.Servlet;

import com.Entity.User;
import com.Mapper.UserMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddWallet", urlPatterns =
{
    "/AddWallet"
})
public class AddWallet extends HttpServlet
{
    ControlLogin cl = new ControlLogin();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {
   //     String username = request.getParameter("username");
        String username = (String) request.getSession().getAttribute("username");
        String password = (String) request.getSession().getAttribute("password");
        double balance = (double) request.getSession().getAttribute("balance");
        double amount = Double.parseDouble(request.getParameter("balance"));

        UserMapper um = new UserMapper();
        User u = new User(username, password);
        User u1 = um.getUser(u);
        balance = u1.getBalance();

  //      System.out.println(username);

        request.getSession().setAttribute("balance", amount);
        if (amount < 20)
        {
            
            request.getRequestDispatcher("Wallet.jsp").forward(request, response);
        } else if(amount > 100){
            
            request.getRequestDispatcher("Wallet.jsp").forward(request, response);
        }
        else{
              u1.setBalance(u1.getBalance() + amount);
              um.updateUser(u1);
              request.getSession().setAttribute("balance", u1.getBalance());
              
              request.getRequestDispatcher("View.jsp").forward(request, response);
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
            Logger.getLogger(AddWallet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddWallet.class.getName()).log(Level.SEVERE, null, ex);
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

//og hvis man højst må have 100 i alt 
//så også lave en check for om (person.getWallet().getBalance() + amount) > 100 så prompt "Du må højst have 100 kroner på din konto. Du har allerede" 
//+ person.getWallet().getbalance() + "så du må højst tilføje " + 100-Person.getWallet().getBalance()
