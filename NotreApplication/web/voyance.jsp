<%-- 
    Document   : voyance.jsp
    Created on : 10 janv. 2019, 09:02:00
    Author     : p1702174
--%>

<%@page import="metier.Prediction"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Ma Voyance en Ligne</title>
    </head>

    <body>
        <form action='' method='get'>
            <div class="input-field col s12">
                <select>
                    <option value="" disabled selected>Choose your option</option>
                    <% 
                    List<String> listTheme = (List<String>) request.getAttribute("listTheme");
                        %>
                        <%
                            for (String s : listTheme) {
                                if (request.getParameterMap().containsKey("theme") && request.getParameter("theme").equals(s)) {
                        %>
                        <option value= <%= s%> selected> <%= s%> <option>
                            <%        } else {
                            %>
                        <option value= <%= s%>> <%= s%> <option>
                            <%        }
                            %>
                            </select>
                            </div>
                        <input type="submit" value="Valider">
                        </form>

                        <%
                            if (request.getParameterMap().containsKey("prediction")) {
                        %>
                        <% Prediction pred = (Prediction) request.getAttribute("prediction"); %>
                        <p>Vous avez tiré la prédiction numéro <%= pred.getId()%> </p>
                        <p>Elle est de catégorie <%= pred.getType()%> </p>
                        <p>Voici votre prediction : <%= pred.getLibelle()%> </p>
                        <%}
                        %>

                        <!--JavaScript at end of body for optimized loading-->
                        <script type="text/javascript" src="js/materialize.min.js"></script>
                        </body>
                        </html>
