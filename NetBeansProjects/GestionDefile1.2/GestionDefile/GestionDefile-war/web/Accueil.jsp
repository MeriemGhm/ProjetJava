<%-- 
    Document   : Accueil
    Created on : Nov 28, 2015, 12:49:31 PM
    Author     : Meriem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d'accueil</title>
    </head>
    <body>
        <h1>Bonjour ! </h1>
                <br/>
                <br/>
                <br/>
                <br/>
        <p>Veuillez saisir vos codes d'accès : </p>
        <form>
            <fieldset>
                <legend>Authentification :</legend>
                    <label for="login">Login<span class="requis">*</span></label>
                    <input type="text" name="login" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="password">Password<span class="requis">*</span></label>
                    <input type="password" name="password" value="" size="20" maxlength="20"/>
                <br/>
                    <%-- permet de passer la valeur du paramètre "action" pour Servlet --%>
                    <input type="hidden" name="action" value="demandeLogin">
            </fieldset>
                    <input type="submit" value="Valider"/>
                    <input type="reset" value="Remettre à zéro"/>
                <br/>
            <table>
                <br/>
                <br/>
                <br/>
                <br/>
            <tr>
                <td width="25%">
                    <a href="MenuPublic.jsp">Accès Public</a>
                </td>
            </tr>
            </table>
        </form>
    </body>
</html>
