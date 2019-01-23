<%@ include file="header.jsp" %>
<main class="container">
    <h4> Choisissez un nom d'utilisateur et un mot de passe </h4>
    <div class="row">
        <div class="card">

            <form method="post" action="?source=accountcréé">
                <div class="card-content">
                    <div class="row">

                        <div class="input-field col s6">
                            <input placeholder="Nom d'utilisateur" type="text" id="un" name="nom" required />
                        </div>
                        <div class="input-field col s6">
                            <input placeholder="Prenom" type="text" id="deux" name="prenom" required />
                        </div>
                        <div class="input-field col s6">
                            <input placeholder="Mot de passe" type="password" id="deux" name="mdp" required />
                        </div>
                    </div>
                </div>
                <div class="card-action">
                    <button class="btn-flat">Créer le compte</button>
                    <a href="?source=home" class="btn-flat">Retour</a>
                </div>
            </form>
        </div>
    </div>
</main>
<%@ include file="footer.jsp" %>
