<%-- 
    Document   : AfficherFrs
    Created on : Nov 3, 2015, 11:45:24 AM
    Author     : Meriem
--%>

<%@page import="td.exo.Fournisseur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listefournisseurs" scope="request" class="java.util.List"></jsp:useBean>
        <title>JSP Afficher Fournisseurs</title>
    </head>
    <body>
        <h1>Afficher Fournisseur</h1>
        <p>
            <% String attribut = (String)request.getAttribute("message");
                out.println(attribut);
            %>
        </p>
        <table border width="50%">
            <tr>
                <td>Numéro</td>
                <td>Nom</td>
                <td>Adresse</td>
                <td>Type</td>
            </tr>
            <%-- List<Fournisseur> lesFour = (List)request.getAttribute("listefournisseurs");--%>
            <% List<Fournisseur> lesFour = listefournisseurs;
                for(Fournisseur cp : lesFour){ 
            %>
            <tr>
                <td width="15%"><%= cp.getId() %></td>
                <td width="15%"><%= cp.getNom() %></td>
                <td width="15%"><%= cp.getAdresse()%></td>
                <td width="15%"><%= cp.getType() %></td>
            </tr>
            <% } %>
        </table>
        <hr>
        <p><font color="Green">Choisissez une action :</font></p>
        <table>
            <tr>
                <td width="25%"><a href="Menu?action=null">Choix</a></td>
            </tr>
        </table>
        <hr>
    </body>
</html>
