/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action;

import com.mysql.cj.jdbc.MysqlDataSource;
import dao.DAOQuery;
import dao.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;
import metier.Trade;
import org.json.JSONObject;

public class HomeAction extends Action {

    @Override
    public String execute(HttpServletRequest request) throws IOException, SQLException {
        MysqlDataSource msqlds = DataSource.getMysqlDataSource();
        DAOQuery.setConnexion(msqlds.getConnection());
        String jsonString = jsonGetRequest("https://api.iextrading.com/1.0/stock/market/previous");
        JSONObject js = new JSONObject(jsonString);
        JSONObject array;
        String symbol;
        List<Trade> listTrade = new ArrayList<Trade>();
        Iterator<String> listeSymbol = js.keys();
        while (listeSymbol.hasNext()) {
            symbol = listeSymbol.next();
            array = js.getJSONObject(symbol);
            if (!array.isNull("open") && !array.isNull("high") && !array.isNull("symbol") && !array.isNull("close") && !array.isNull("low")) {
                listTrade.add(new Trade(array.getString("symbol"), array.getFloat("open"), array.getFloat("high"), array.getFloat("close"), array.getFloat("low")));
            }
        }
        request.setAttribute("listTrade", listTrade);
        return "home.jsp";
    }

    private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        return text;
    }

    public static String jsonGetRequest(String urlQueryString) {
        String json = null;
        try {
            URL url = new URL(urlQueryString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream); // input stream to string
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }

}
