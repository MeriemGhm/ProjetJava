<%-- 
    Document   : creerVetement
    Created on : Nov 10, 2015, 12:12:04 PM
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
        <h1>Créer un nouveau vêtement</h1>
        <form method="get" action="Menu">
            <fieldset>
                <legend>Informations Vêtement</legend>
                    <label for="frsVet">Numéro du fournisseur<span class="requis">*</span></label>
                    <input type="text" name="frsVet" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="designationVet">Designation<span class="requis">*</span></label>
                    <input type="text" name="designationVet" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="prixVet">Prix<span class="requis">*</span></label>
                    <input type="text" name="prixVet" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="typeVet">Type<span class="requis">*</span></label>
                    <input type="text" name="typeVet" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="coloriVet">Colori<span class="requis">*</span></label>
                    <input type="text" name="coloriVet" value="" size="20" maxlength="20"/>
                <br/>
                    <%-- permet de passer la valeur du paramètre "action" pour Servlet --%>
                    <input type="hidden" name="action" value="creerV">
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
