<%-- 
    Document   : creerFraicheur
    Created on : Nov 10, 2015, 12:14:49 PM
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
        <h1>Créer un nouveau Produit Frais</h1>
        <form method="get" action="Menu">
            <fieldset>
                <legend>Informations Produit Frais</legend>
                    <label for="frsProd">Numéro du fournisseur<span class="requis">*</span></label>
                    <input type="text" name="frsProd" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="designationProd">Designation<span class="requis">*</span></label>
                    <input type="text" name="designationProd" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="prixProd">Prix<span class="requis">*</span></label>
                    <input type="text" name="prixProd" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="typeProd">Type<span class="requis">*</span></label>
                    <input type="text" name="typeProd" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="limitProd">Date limite de consommation<span class="requis">*</span></label>
                    <input type="date" name="limitProd" value="" size="20" maxlength="20"/>
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
