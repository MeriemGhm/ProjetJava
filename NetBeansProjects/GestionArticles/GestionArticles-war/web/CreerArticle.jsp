<%-- 
    Document   : CreerArticle
    Created on : Nov 10, 2015, 12:08:01 PM
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
        <h1>Créer un nouvel article</h1>
        <form method="get" action="Menu">
            <fieldset>
                <legend>Informations Article</legend>
                    <label for="frsArticle">Numéro du fournisseur<span class="requis">*</span></label>
                    <input type="text" name="frsArticle" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="designationArticle">Designation<span class="requis">*</span></label>
                    <input type="text" name="designationArticle" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="prixArticle">Prix<span class="requis">*</span></label>
                    <input type="text" name="prixArticle" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="typeArticle">Type<span class="requis">*</span></label>
                    <input type="text" name="typeArticle" value="" size="20" maxlength="20"/>
                <br/>
                    <%-- permet de passer la valeur du paramètre "action" pour Servlet --%>
                    <input type="hidden" name="action" value="creerA">
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
