package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOQuery {

    private static Connection connexionBD;

    public static PreparedStatement query(String req) {
        PreparedStatement pstmt = null;

        try {
            pstmt = connexionBD.prepareStatement(req);
            pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pstmt;
    }
    
    public static Statement update(String req) {
        try {
            Statement pstmt = connexionBD.createStatement();
            
            try {
                pstmt.executeUpdate(req);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            return pstmt;
        } catch (SQLException ex) {
            Logger.getLogger(DAOQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static PreparedStatement query(String req, String[] args) {
        PreparedStatement pstmt = null;

        try {
            pstmt = connexionBD.prepareStatement(req);
            for (int i = 0; i < args.length; i++) {
                pstmt.setString(i + 1, args[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pstmt;
    }

    public static void setConnexion(Connection connexion) {
        connexionBD = connexion;
    }
}
