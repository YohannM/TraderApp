package controller.action;

import com.mysql.cj.jdbc.MysqlDataSource;
import dao.DAOQuery;
import dao.DAOUser;
import dao.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import metier.Utilisateur;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author p1700402
 */
public class ConnexionAction extends Action {

    public String execute(HttpServletRequest request) throws IOException, SQLException {
        MysqlDataSource msqlds = DataSource.getMysqlDataSource();
        DAOQuery.setConnexion(msqlds.getConnection());
        String nom = request.getParameter("nom");
        String mdp = request.getParameter("mdp");
        if (mdp != null && nom != null) {
            DAOUser userDao = new DAOUser();
            Utilisateur user = userDao.checkUserExist(nom, mdp);
            if (user != null) {
                request.getSession().setAttribute("user_id", user.getId());
                HomeAction home = new HomeAction();
                return home.execute(request);
            } else {
                request.setAttribute("Erreur", "Il y a une erreur dans le nom ou mot de passe");
            }
        }
        return "connexion.jsp";
    }
}
