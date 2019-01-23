package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import metier.Utilisateur;


public class DAOUser {
    
    
    public List<Utilisateur> selectAllUser() 
    {
    	Statement stmt;
    	
    	List<Utilisateur> ls = new ArrayList<> ();
    	stmt = DAOQuery.query("SELECT * FROM Utilisateur");
    	
    	
    	if (stmt != null)
    	{
            try 
            {
                ResultSet rset = stmt.getResultSet();

                while (rset.next()) 
                {
                    ls.add(new Utilisateur(rset.getInt("IdUtilisateur"), rset.getString("PrenomUtilisateur"), rset.getString("NomUtilisateur"), rset.getString("pwd")));
                }
            } 
            catch (SQLException e) 
            {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
    	}
    	
        
    	return ls;
    }
    
    public void addUser(String prenom, String nom, String pwd)
    {
        Statement stmt;
        stmt = DAOQuery.update("INSERT INTO Utilisateur (PrenomUtilisateur, NomUtilisateur, pwd) "
                + "VALUES ('" + prenom + "', '" + nom + "', '" + pwd + "')");
    }
    
    public Utilisateur checkUserExist(String nom, String pwd)
    {
        Statement stmt;
    	
    	Utilisateur u = null;
    	stmt = DAOQuery.query("SELECT * FROM Utilisateur WHERE NomUtilisateur = '" + nom + "' "
                + "AND pwd = '" + pwd + "';");
    	
    	
    	if (stmt != null)
    	{
            try 
            {
                ResultSet rset = stmt.getResultSet();

                while (rset.next()) 
                {
                    u = new Utilisateur(rset.getInt("IdUtilisateur"), rset.getString("PrenomUtilisateur"), rset.getString("NomUtilisateur"), rset.getString("pwd"));
                }
            } 
            catch (SQLException e) 
            {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
    	}
    	
        
    	return u;
    }
}
