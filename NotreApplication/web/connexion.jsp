<%@ include file="header.jsp" %>
<main class="container">
    <h4>Se connecter</h4>
    <div class="row">
        <div class="card">

            <form method="post" action="?source=connexion">
                <div class="card-content">
                    <div class="row">
                        <p class="red-text"><%=(request.getAttribute("Erreur") != null) ? (String) request.getAttribute("Erreur") : ""%>
                        <div class="input-field col s6">
                            <input placeholder="Nom d'utilisateur" type="text" id="un" name="nom" required />
                        </div>
                        <div class="input-field col s6">
                            <input placeholder="Mot de passe" type="password" id="deux" name="mdp" required />
                        </div>
                    </div>
                </div>
                <div class="card-action">
                    <button class="btn-flat">Se connecter</button>
                    <a href="?source=home" class="btn-flat">Retour</a>
                </div>
            </form>
        </div>
    </div>
</main>
<%@ include file="footer.jsp" %>
