<%-- 
    Document   : Choix
    Created on : Nov 3, 2015, 11:13:03 AM
    Author     : Meriem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Choix</title>
    </head>
    <body>
        <h1>Que voulez-vous faire ?</h1>
        <table>
            <tr>
                <td width="25%">
                    <a href="SaisirFrs.jsp">Créer Fournisseur</a>
                </td>
            </tr>
            <tr>
                <td width="25%">
                    <a href="CreerArticle.jsp">Créer un Article</a>
                </td>
            </tr>
            <tr>
                <td width="25%">
                    <a href="CreerFraicheur.jsp">Créer un Produit Frais</a>
                </td>
            </tr>
            <tr>
                <td width="25%">
                    <a href="CreerVetement.jsp">Créer un Vetement</a>
                </td>
            </tr>
            <tr>
                <td width="25%">
                    <a href="Menu?action=afficherFrs">Afficher Fournisseurs</a>
                </td>
            </tr>
            <tr>
                <td width="25%">
                    <a href="Menu?action=afficherArtFrs">Rechercher les articles d'un fournisseur</a>
                </td>
            </tr>
        </table>
    </body>
</html>
