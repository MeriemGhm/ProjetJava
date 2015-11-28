<%-- 
    Document   : SaisirFrs
    Created on : Nov 3, 2015, 11:12:42 AM
    Author     : Meriem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Créer fournisseur</title>
    </head>
    <body>
        <h1>Créer un nouveau fournisseur</h1>
        <form method="get" action="Menu">
            <fieldset>
                <legend>Informations Fournisseur</legend>
                    <label for="nomFournisseur">Nom<span class="requis">*</span></label>
                    <input type="text" name="nomFournisseur" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="adresseFournisseur">Adresse<span class="requis">*</span></label>
                    <input type="text" name="adresseFournisseur" value="" size="20" maxlength="20"/>
                <br/>
                <tr>
                    <td>Type de fournisseur</td>
                        <td>
                            <SELECT size="1" name="type">
                                <OPTION value="National">National</OPTION>
                                <OPTION value="Regional">Régional</OPTION>
                            </SELECT>
                        </td>
                </tr>
                    
                <br/>
                    <%-- permet de passer la valeur du paramètre "action" pour Servlet --%>
                    <input type="hidden" name="action" value="insererF">
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
