<%@ include file="header.jsp" %>
<main class="container">
    <h4>Mes Trades</h4>
    <%@page import="metier.*" %>
    <%@page import="java.util.List" %>
    <%@page import="org.json.*"%>
    <%@page import="java.util.Iterator"%>

    <% JSONObject js = (JSONObject) request.getAttribute("JsonObject");
        Iterator<String> listeSymbol = js.keys();
        JSONArray contenu;
        while (listeSymbol.hasNext()) {
            String symbol = listeSymbol.next();
            if (js.getJSONObject(symbol).has("chart"))
            {
                contenu = js.getJSONObject(symbol).getJSONArray("chart");
    %>
    <div class="card">
        <div class="card-content">
            <span class="card-title"><%=symbol%></span>
            <table class="centered highlight">
                <thead>
                <th>Date</th>
                <th>Open</th>
                <th>High</th>
                <th>Low</th>
                <th>Close</th>
                </thead>
                <tbody>
                    <%
                        for(int i = contenu.length() - 6;i < contenu.length(); i++)
                        {
                    %>
                    <tr class="<%=(contenu.getJSONObject(i).getFloat("open") - contenu.getJSONObject(i).getFloat("close") < 0) ? "green" : "red"%>">
                        <td><%=contenu.getJSONObject(i).getString("date")%></td>
                        <td><%=(contenu.getJSONObject(i).has("open")) ? contenu.getJSONObject(i).getFloat("open") : ""%></td>
                        <td><%=(contenu.getJSONObject(i).has("high")) ? contenu.getJSONObject(i).getFloat("high") : ""%></td>
                        <td><%=(contenu.getJSONObject(i).has("low")) ? contenu.getJSONObject(i).getFloat("low") : ""%></td>
                        <td><%=(contenu.getJSONObject(i).has("close")) ? contenu.getJSONObject(i).getFloat("close") : ""%></td>
                    </tr>
                    <% }
                    %>
                </tbody>
            </table>
        </div>
    </div>
                <% }} %>
</main>
<%@ include file="footer.jsp" %>