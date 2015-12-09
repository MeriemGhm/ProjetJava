<%-- 
    Document   : MenuOrganisateur
    Created on : Nov 28, 2015, 2:40:15 PM
    Author     : Meriem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Organisateur</title>
    </head>
    <body>
        <h1>Bienvenue ! </h1>
        
        <table>
            <br/>
            <br/>
            <h1>Menu</h1>
            <br/>
            <br/>
                <p>Statistiques</p>
            <tr>
                <td width="25%">
                    <img src="Icones/stats.png"/><a href="StatDefile.jsp">Statistiques défilés</a>
                </td>
            </tr>
            <br/>
            <p>Recherches</p>
                <tr>
                    <td width="25%">
                        <a href="RechercheDefile.jsp">Rechercher des défilés</a>
                    </td>
                </tr>
            <br/>
            <p>Créations</p>sss
                 <tr>
                    <td width="25%">
                        <a href="Menu?action=newDefile">Saisir nouveau défilés</a>
                    </td>
                </tr>
        </table>
    </body>
</html>
