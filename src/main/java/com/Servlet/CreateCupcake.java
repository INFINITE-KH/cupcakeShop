package com.Servlet;

import com.Entity.Bottoms;
import com.Entity.Toppings;
import com.Entity.User;
import com.Mapper.BottomsMapper;
import com.Mapper.UserMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreateCupcake", urlPatterns =
{
    "/CreateCupcake"
})
public class CreateCupcake extends HttpServlet
{

    double bottomprice;
    double toppingprice;
    double total;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
    {
        ArrayList<Bottoms> list = (ArrayList<Bottoms>) request.getSession().getAttribute("bottom");
        ArrayList<Toppings> list2 = (ArrayList<Toppings>) request.getSession().getAttribute("topping");
        UserMapper um = new UserMapper();
        System.out.println("BLIVER KØRT");
//        for (int i = 0; i > list.size(); i++)
//        {
//            String tempbottom = request.getParameter("bottombutton" + i);
//            if (tempbottom.equals("Chosen"))
//            {
//                bottomprice = list.get(i).getPrice();
//                request.getSession().setAttribute("bottomprice", bottomprice);
//            }
//        }
//        for (int i = 0; i > list2.size(); i++)
//        {
//            String temptopping = request.getParameter("toppingbutton" + i);
//            if (temptopping.equals("Chosen"))
//            {
//                toppingprice = list2.get(i).getPrice();
//                request.getSession().setAttribute("toppingprice", toppingprice);
//            }
//        }
//        total = bottomprice+toppingprice;
//        
//        if(request.getParameter("order") != null){
//            if(request.getSession().getAttribute("bottomprice") != null){
//                if(request.getSession().getAttribute("toppingprice") != null){
//                    User u = new User(request.getSession().getAttribute("username").toString(), request.getSession().getAttribute("password").toString());
//                    total = (double) request.getSession().getAttribute("bottomprice") + (double) request.getSession().getAttribute("toppingprice");
//                    if(u.getBalance()<total){
//                        request.getSession().setAttribute("cupcakestatus", "Not enough money in your wallet");
//                        request.getRequestDispatcher("CupcakeCreator.jsp").forward(request, response);
//                    } else{
//                        u.setBalance(u.getBalance() - total);
//                        um.updateUser(u);
//                        request.getRequestDispatcher("View.jsp").forward(request, response);
//                    }
//
//                }
//                
//            }
//        }
//        request.getSession().setAttribute("bottom", ());
//        request.getSession().setAttribute("price", ());
        request.getRequestDispatcher("CupcakeCreator.jsp").forward(request, response);
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
            Logger.getLogger(CreateCupcake.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CreateCupcake.class.getName()).log(Level.SEVERE, null, ex);
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
