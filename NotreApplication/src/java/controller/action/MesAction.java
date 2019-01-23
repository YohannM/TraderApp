package controller.action;

import com.mysql.cj.jdbc.MysqlDataSource;
import static controller.action.HomeAction.jsonGetRequest;
import dao.DAOQuery;
import dao.DAOUserTrade;
import dao.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

public class MesAction extends Action {

    public String execute(HttpServletRequest request) throws IOException, SQLException {
        HttpSession session = request.getSession();
        MysqlDataSource msqlds = DataSource.getMysqlDataSource();
        DAOQuery.setConnexion(msqlds.getConnection());
        DAOUserTrade userTrade = new DAOUserTrade();
        List<String> listSymbol = userTrade.selectAllSymb((int) request.getSession().getAttribute("user_id"));
        String symbols = "";
        boolean first = true;
        for(String  symbol : listSymbol)
        {
            symbols = symbols + ((!first) ? "," : "") + symbol;
            first = false;
        }
        String jsonString = jsonGetRequest("https://api.iextrading.com/1.0/stock/market/batch?symbols=" + symbols + "&types=quote,news,chart&range=1m&last=5");
        JSONObject js = new JSONObject(jsonString);
        request.setAttribute("JsonObject", js);
        return "mesActions.jsp";
    }

}
