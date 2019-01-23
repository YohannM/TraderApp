package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DAOUserTrade {
    
    
    public List<String> selectAllSymb(int idUser) 
    {
    	Statement stmt;
    	
    	List<String> ls = new ArrayList<> ();
    	stmt = DAOQuery.query("SELECT SymbolTrade FROM Trade t, User_Trade u "
                + "WHERE u.IdTrade = t.IdTrade AND IdUser = '" + idUser + "'");
    	
    	
    	if (stmt != null)
    	{
            try 
            {
                ResultSet rset = stmt.getResultSet();

                while (rset.next()) 
                {
                    ls.add(rset.getString("SymbolTrade"));
                }
            } 
            catch (SQLException e) 
            {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
    	}
    	
        
    	return ls;
    }
    
    public void DeleteAllTradeFromUserId(int idUser) 
    {
    	Statement stmt;
    	stmt = DAOQuery.update("DELETE FROM User_Trade WHERE IdUser = '" + idUser + "'");
    }
    
    public void AddTradeToUser(int idUser, int idTrade) 
    {
    	Statement stmt;
    	stmt = DAOQuery.update("INSERT INTO User_Trade VALUES (" + idUser + ", " + idTrade + ")");
    	
    }
}
