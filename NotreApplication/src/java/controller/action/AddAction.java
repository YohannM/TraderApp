package controller.action;

import com.mysql.cj.jdbc.MysqlDataSource;
import static controller.action.HomeAction.jsonGetRequest;
import dao.DAOQuery;
import dao.DAOTrade;
import dao.DAOUserTrade;
import dao.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import metier.Trade;
import org.json.JSONObject;

public class AddAction extends Action {

    public String execute(HttpServletRequest request) throws IOException, SQLException
    {
        MysqlDataSource msqlds = DataSource.getMysqlDataSource();
        DAOQuery.setConnexion(msqlds.getConnection());
        String jsonString = jsonGetRequest("https://api.iextrading.com/1.0/stock/market/previous");
        Enumeration<String> listParam = request.getParameterNames();
        DAOTrade trade = new DAOTrade();
        DAOUserTrade userTrade = new DAOUserTrade();
        boolean reset = false;
        while(listParam.hasMoreElements())
        {
            String element = listParam.nextElement();
            if(!element.equals("source"))
            {
                if(!reset)
                {
                    userTrade.DeleteAllTradeFromUserId((int) request.getSession().getAttribute("user_id"));
                    reset = true;
                }
                userTrade.AddTradeToUser((int) request.getSession().getAttribute("user_id"),trade.getIdFromSymb(element));
            }
        }
        if (reset)
        {
            MesAction acc = new MesAction();
            return acc.execute(request);
        }
        JSONObject js = new JSONObject(jsonString);
        JSONObject array;
        String symbol;
        List<String> listTradeUser = userTrade.selectAllSymb((int) request.getSession().getAttribute("user_id"));
        List<Trade> listTrade = new ArrayList<Trade>();
        Iterator<String> listeSymbol = js.keys();
        while (listeSymbol.hasNext()) {
            symbol = listeSymbol.next();
            array = js.getJSONObject(symbol);
            if (!array.isNull("open") && !array.isNull("high") && !array.isNull("symbol") && !array.isNull("close") && !array.isNull("low")) {
                listTrade.add(new Trade(array.getString("symbol"), array.getFloat("open"), array.getFloat("high"), array.getFloat("close"), array.getFloat("low")));
            }
        }
        request.setAttribute("listTradeUser", listTradeUser);
        request.setAttribute("listTrade", listTrade);
        return "addAction.jsp";
    }

}
