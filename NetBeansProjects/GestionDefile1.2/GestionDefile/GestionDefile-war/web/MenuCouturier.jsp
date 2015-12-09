<%-- 
    Document   : MenuCouturier
    Created on : Nov 28, 2015, 2:40:07 PM
    Author     : Meriem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Couturier</title>
    </head>
    <body>
        <h1>Bienvenue ! </h1>
            <br/>
            <br/>
                <h1>Menu</h1>
                <table>
                    <tr>
                        <td>Statistiques</td>
                    <tr/>
                    <tr>
                        <td>
                            <img src="Icones/stats.png"/><a href="StatVetement.jsp">Statistiques vêtements</a>
                        <td/>
                    <tr/>
                </table>
                <hr>
                <table>
                    <tr>
                        <td>Recherches</td>
                    <tr/>
                    <tr> 
                        <td width="25%">
                            <a href="RechercheDefile.jsp">Rechercher des défilés</a>
                        </td>
                        <td width="25%">     
                            <img src="Icones/find_user.png"/><a href="RechercheMannequin.jsp">Rechercher des mannequins</a>
                        </td>
                        <td width="25%">      
                            <a href="RechercheVetement.jsp">Rechercher des vêtements</a>
                        </td>
                        <td width="25%">
                            <a href="RechercheAccessoires.jsp">Rechercher des accessoires</a>
                        </td>
                    </tr>
                </table> 
                <hr>
                <table>
                    <tr>
                        <td>Ajout</td>
                    <tr/>
                    <tr>  
                        <td width="25%">
                            <img src="Icones/add_user.png"/><a href="SaisirMannequin.jsp">Ajouter un nouveau mannequin</a>
                        </td>
                        <td width="25%">      
                            <img src="Icones/vetement.png"/><a href="SaisirVetement.jsp">Ajouter un nouveau vêtement</a>
                        </td>
                        <td width="25%">
                            <img src="Icones/accessoires.png"/><a href="SaisirAccessoire.jsp">Ajouter un nouvel accessoire</a>
                        </td>
                    </tr>
                </table>
    </body>
</html>
