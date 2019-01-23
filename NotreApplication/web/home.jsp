
<%@ include file="header.jsp" %>
        <main class="container">
            <h4>Page d'accueil</h4>
            <%@page import="metier.*" %>
            <%@page import="java.util.List" %>
            <table class="centered highlight">
                <thead>
                <th>Symbol</th>
                <th>Open</th>
                <th>High</th>
                <th>Low</th>
                <th>Close</th>
                </thead>
                <tbody>
                    <%    
                        List<Trade> listTrade = (List<Trade>) request.getAttribute("listTrade");
                        for (Trade trade : listTrade) {
                    %>
                    <tr class="<%= (trade.getClose() - trade.getOpen() < 0) ? "red" : "green"%>">
                        <td><%= trade.getSymbol()%></td>
                        <td><%= trade.getOpen()%></td>
                        <td><%= trade.getHigh()%></td>
                        <td><%= trade.getLow()%></td>
                        <td><%= trade.getClose()%></td>
                    </tr>
                    <% }
                    %>
                </tbody>
            </table>  
        </main>
<%@ include file="footer.jsp" %>
