<%-- 
    Document   : SaisirVetement
    Created on : 1 déc. 2015, 09:45:23
    Author     : 3097376
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saisie Vêtement</title>
    </head>
    <body>
       <h1>Créer un nouveau vêtement</h1>
        <form method="get" action="Menu">
            <fieldset>
                <legend>Informations Vêtement</legend>
                    <label for="dateCreation">Date création<span class="requis">*</span></label>
                    <input type="date" name="dateCreation" value="" size="20" maxlength="20"/>
                <br/>
                <br/>
                    <label for="libelle">Libellé<span class="requis">*</span></label>
                    <input type="text" name="libelle" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="taille">Taille<span class="requis">*</span></label>
                    <input type="text" name="taille" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="colori">Colori<span class="requis">*</span></label>
                    <input type="text" name="colori" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="matiere">Matière<span class="requis">*</span></label>
                    <input type="text" name="matiere" value="" size="20" maxlength="20"/>
                <br/>
                <br/>
                    <label for="position">Position<span class="requis">*</span></label>
                    <input type="number" name="position" value="" size="20" maxlength="20"/>
                <br/>
                    <%-- permet de passer la valeur du paramètre "action" pour Servlet --%>
                    <input type="hidden" name="action" value="creerVetement">
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
