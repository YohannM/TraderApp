/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.action.AddAction;
import controller.action.ConnexionAction;
import controller.action.CreateAccountAction;
import controller.action.HomeAction;
import controller.action.LogoutAction;
import controller.action.MesAction;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natov
 */
@WebServlet(name = "SuperController", urlPatterns = {"/Trader"})
public class SuperController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String source = (request.getParameter("source") == null) ? "home" : request.getParameter("source");
        RequestDispatcher rd;
        String vue;
        switch (source) {
            case "connexion":
                ConnexionAction ac = new ConnexionAction();
                vue = ac.execute(request);
                break;
            case "createAccount":
                vue = "createAccount.jsp";
                break;
            case "addAction":
                AddAction add = new AddAction();
                vue = add.execute(request);
                break;
            case "mesActions":
                MesAction act = new MesAction();
                vue = act.execute(request);
                break;
            case "accountcréé":
                CreateAccountAction caa = new CreateAccountAction();
                vue = caa.execute(request);
                break;
            case "home":
                HomeAction home = new HomeAction();
                vue = home.execute(request);
                break;
            case "logout":
                LogoutAction log = new LogoutAction();
                vue = log.execute(request);
                break;
            default:
                HomeAction hom = new HomeAction();
                vue = hom.execute(request);
                break;
        }
        rd = request.getRequestDispatcher(vue);
        rd.forward(request, response);
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
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SuperController.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SuperController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
