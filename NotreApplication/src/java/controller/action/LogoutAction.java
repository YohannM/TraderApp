/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author natov
 */
public class LogoutAction extends Action {

    public String execute(HttpServletRequest request) throws IOException, SQLException {
        request.getSession().setAttribute("user_id", null);
        HomeAction home = new HomeAction();
        return home.execute(request);
    }
}
