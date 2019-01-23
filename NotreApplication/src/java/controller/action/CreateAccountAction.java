package controller.action;

import com.mysql.cj.jdbc.MysqlDataSource;
import dao.DAOQuery;
import dao.DAOUser;
import dao.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p1700402
 */
public class CreateAccountAction extends Action{
    public String execute(HttpServletRequest request) throws IOException, SQLException
    {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mdp = request.getParameter("mdp");
        if (nom == null || prenom == null || mdp == null)
        {
           return "createAccount.jsp";
        }
        else 
        {
            MysqlDataSource msqlds = DataSource.getMysqlDataSource();
            DAOQuery.setConnexion(msqlds.getConnection());
            DAOUser userDao = new DAOUser();
            userDao.addUser(prenom, nom, mdp);
            request.getSession().setAttribute("user_id",userDao.checkUserExist(nom,mdp).getId());
            HomeAction home = new HomeAction();
            return home.execute(request);
        }
    }
}
