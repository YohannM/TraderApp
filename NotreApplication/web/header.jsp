<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" href = "css/materialize.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script> 
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Trader App</title>
    </head>
    <body>
        <nav>
            <div class="nav-wrapper">
                <a href="?source=home" class="brand-logo">My Trader App</a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <% if (request.getSession().getAttribute("user_id") != null)
                        {
                    %>
                    <li><a href="?source=addAction">Ajouter des actions</a></li>
                    <li><a href="?source=mesActions">Mes actions</a></li>
                    <li><a href="?source=logout">Se deconnecter</a></li>
                    <% } else { %>
                    <li><a href="?source=connexion">Se connecter</a></li>
                    <li><a href="?source=createAccount">Créer un compte</a></li>
                    <% } %>
                </ul>
            </div>
        </nav>
