package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import metier.Trade;
import org.json.JSONObject;
import static utils.JSONRequester.jsonGetRequest;


public class DAOTrade {
    
    public List<Trade> selectAllTrade() 
    {
    	List<Trade> lp = new ArrayList<> ();
    	String jsonString = jsonGetRequest("https://api.iextrading.com/1.0/stock/market/previous");
            JSONObject js = new JSONObject(jsonString);
            JSONObject array;
            String symbol;
            List<Trade> listTrade = new ArrayList<>();
            Iterator<String> listeSymbol = js.keys();
            while(listeSymbol.hasNext())
            {
                symbol = listeSymbol.next();
                System.out.println(symbol);
                array = js.getJSONObject(symbol);
                if (!array.isNull("open") && !array.isNull("high") && !array.isNull("symbol") && !array.isNull("close") && !array.isNull("low"))
                {    
                    listTrade.add(new Trade(array.getString("symbol"),array.getFloat("open"),array.getFloat("high"),array.getFloat("close"),array.getFloat("low")));
                }
            }
    	return listTrade;
    }
    
    // ATTENTION CETTE METHODE EST DANGEREUSE
    private void addAllTrade() 
    {
    	List<Trade> lp = selectAllTrade();
    	int i = 1;
        for(Trade tr : lp)
        {
            Statement stmt;
            System.out.println("");
            stmt = DAOQuery.update("INSERT INTO Trade VALUES (" + i + ",'" + 
                    tr.getSymbol() +"')");
            i++;
        }
    }
    
    public int getIdFromSymb(String symb)
    {
        Statement stmt;
    	
    	int id = 1;
    	stmt = DAOQuery.query("SELECT IdTrade FROM Trade WHERE SymbolTrade = '" + symb + "'");
    	
    	
    	if (stmt != null)
    	{
            try 
            {
                ResultSet rset = stmt.getResultSet();

                while (rset.next()) 
                {
                    id = rset.getInt("IdTrade");
                }
            } 
            catch (SQLException e) 
            {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
    	}
    	
        
    	return id;
    }
}
