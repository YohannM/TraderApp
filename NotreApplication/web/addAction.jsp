<%@ include file="header.jsp" %>
<main class="container">
    <h4>Ajouter des trades</h4>
    <%@page import="metier.*" %>
    <%@page import="java.util.List" %>
    

    <form action="#" method="POST">
    <table class="centered highlight">
        <thead>
        <th>Symbol 1</th>
        <th>Symbol 2</th>
        </thead>
        <tbody>
            <%
                List<Trade> listTrade = (List<Trade>) request.getAttribute("listTrade");
                List<String> listTradeUser = (List<String>) request.getAttribute("listTradeUser");
                boolean continu = false;
                for (Trade trade : listTrade) {
            %>
            <%=(continu) ? "" : "<tr>"%>
                <td><label>
                        <input name="<%=trade.getSymbol()%>" id="<%=trade.getSymbol()%>" type="checkbox" <%=(listTradeUser.contains(trade.getSymbol())) ? "checked" : ""%>/>
        <span><%=trade.getSymbol()%></span>
      </label></td>
            <%=(continu) ? "</tr>" : ""%>
            <% continu = (continu) ? false: true;}
            %>
        </tbody>
    </table> 
        <div class="fixed-action-btn">
  <button class="btn-floating btn-large">
    <i class="material-icons">add</i>
  </button>
</div>
    </form>
</main>
            <script>
                
  document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.fixed-action-btn');
    var instances = M.FloatingActionButton.init(elems, null);
  });
                </script>
<%@ include file="footer.jsp" %>