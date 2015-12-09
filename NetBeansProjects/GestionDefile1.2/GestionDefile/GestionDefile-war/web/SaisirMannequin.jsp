<%-- 
    Document   : SaisirMannequin
    Created on : Nov 28, 2015, 3:19:32 PM
    Author     : Meriem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer un mannequin</title>
    </head>
    <body>
        <h1>Créer un nouveau compte mannequin</h1>
        <form method="get" action="Menu">
            <fieldset>
                <legend>Informations Mannequin</legend>
                    <label for="nom">Nom<span class="requis">*</span></label>
                    <input type="text" name="nom" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="prenom">Prénom<span class="requis">*</span></label>
                    <input type="text" name="prenom" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="adresse">Adresse<span class="requis">*</span></label>
                    <input type="text" name="adresse" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="telephone">Téléphone<span class="requis">*</span></label>
                    <input type="text" name="telephone" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="login">Login<span class="requis">*</span></label>
                    <input type="text" name="login" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="password">Mot de passe<span class="requis">*</span></label>
                    <input type="password" name="password" value="" size="20" maxlength="20"/>
                <br/>
                <br/>
                    <label for="salaire">Salaire<span class="requis">*</span></label>
                    <input type="text" name="salaire" value="" size="20" maxlength="20"/>
                <br/>
                    <%-- permet de passer la valeur du paramètre "action" pour Servlet --%>
                    <input type="hidden" name="action" value="creerMannequin">
            </fieldset>
            <hr>
                <br/>
                    <input type="submit" value="Valider"/>
                    <input type="reset" value="Remettre à zéro"/>
                <br/>
            <hr>
            <p><font color="Green">Choisissez une action :</font></p>
            <table>
                <tr>
                    <td width="25%"><a href="Menu?action=home"><img src="Icones/home.png"/></a></td>
                </tr>
            </table>
            <hr>
        </form>
    </body>
</html>
