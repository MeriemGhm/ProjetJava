<%-- 
    Document   : RechercherArticlesFrs
    Created on : Nov 10, 2015, 12:17:20 PM
    Author     : Meriem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Afficher Articles d'un Fournisseur</h1>
        <form method="get" action="afficherArtFrs">
            <fieldset>
                    <label for="numFour">Numéro du fournisseur<span class="requis">*</span></label>
                    <input type="text" name="numFour" value="" size="20" maxlength="20"/>
                <br/>
                    <%-- permet de passer la valeur du paramètre "action" pour Servlet --%>
                    <input type="hidden" name="action" value="rechArtFrs">
            </fieldset>
                    <input type="submit" value="Valider"/>
                    <input type="reset" value="Remettre à zéro"/>
                <br/>
            <hr>
            <p><font color="Green">Choisissez une action :</font></p>
            <table>
                <tr>
                    <td width="25%"><a href="Menu?action=null">Choix</a></td>
                </tr>
            </table>
            <hr>
        </form>
    </body>
</html>
