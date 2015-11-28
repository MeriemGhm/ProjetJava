<%-- 
    Document   : AfficherArticlesFrs
    Created on : Nov 10, 2015, 8:13:04 PM
    Author     : Meriem
--%>

<%@page import="td.exo.Article"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listearticles" scope="request" class="java.util.List"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Afficher Articles d'un Fournisseur</h1>
        <p>
            <% String attribut = (String)request.getAttribute("message");
                out.println(attribut);
            %>
        </p>
        <table border width="50%">
            <tr>
                <td>Numéro</td>
                <td>Désignation</td>
                <td>Prix</td>
                <td>Type</td>
                <%--<td>Colori</td>--%>
                <%--<td>Date limite</td>--%>
            </tr>
           
            <% List<Article> lesArt = listearticles;
                for(Article a : lesArt){ 
            %>
            <tr>
                <td width="15%"><%= a.getId() %></td>
                <td width="15%"><%= a.getDesignation() %></td>
                <td width="15%"><%= a.getPrix()%></td>
                <td width="15%"><%= a.getType() %></td>
                <%--<td width="15%"><%=  %></td> --%>
            </tr>
            <% } %>
        </table>
        <hr>
        <p><font color="Green">Choisissez une action :</font></p>
        <table>
            <tr>
                <td width="25%"><a href="Menu?action=null">Retour au menu principal</a></td>
            </tr>
        </table>
        <hr>
    </body>
</html>
