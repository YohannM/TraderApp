/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesServ;

import dao.DAOQuery;
import dao.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author p1702174
 */
@WebServlet(name = "MaServlet", urlPatterns = {"/MaServlet"})
public class MaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // DAOTrade daoPred = new DAOTrade();
    //daoPredTheme daoThemePred = new daoPredTheme();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        Connection con = null;
        try {
            con = DataSource.getMysqlDataSource().getConnection();
            DAOQuery.setConnexion(con);
        } catch (SQLException ex) {
            Logger.getLogger(MaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (con == null) {
            try {
                throw new NullConnection();
            } catch (NullConnection ex) {
                Logger.getLogger(MaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        DAOQuery.setConnexion(con);

        // List<String> listTheme = daoThemePred.getPredTheme();
        
        //Integer nbrPred = daoPred.getPredictionNumber();
        

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Voyance en ligne</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienvenue sur votre service de voyance en ligne</h1>");
            out.println("<FORM>"
                    + "    <SELECT name='theme' size='1'>");
                    
            /*for(String s : listTheme)
            {
                if (request.getParameterMap().containsKey("theme") && request.getParameter("theme").equals(s))
                    out.println("<OPTION value='" + s + "' selected> " + s);
                else
                    out.println("<OPTION value='" + s + "'> " + s);
            }
            
            out.println("    </SELECT>"
                    +  "<input type='submit' value='Recevoir ma prédiction'>"
                    + "    </FORM action='' method='get'>");
            
            if(request.getParameterMap().containsKey("theme"))
            {
                /*Prediction pred = DAOTrade.select("SELECT * FROM Predictions WHERE TYPE_PRED = '" + request.getParameter("theme")+"'");
                out.println("<p>Vous avez tiré la prédiction numéro " + pred.getId() + "</p>");
                out.println("<p>Elle est de catégorie " + pred.getType() + "</p>");
                out.println("<p>Voici votre prediction : " + pred.getLibelle() + "</p>");*/
            //}
            out.println("</body>");
            out.println("</html>");
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
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
