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
 * @author p1700402
 */
public abstract class Action {
    public abstract String execute(HttpServletRequest request) throws IOException, SQLException;
}
