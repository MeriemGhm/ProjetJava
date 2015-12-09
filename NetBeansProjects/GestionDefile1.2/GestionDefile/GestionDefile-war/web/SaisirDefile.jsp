<%-- 
    Document   : SaisirDefile
    Created on : 1 déc. 2015, 11:21:54
    Author     : 3097376
--%>

<%@page import="td.exam.BeansEntite.Couturier"%>
<%@page import="java.util.Collection"%>
<%@page import="td.exam.BeansEntite.Lieu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeLieux" scope="request" class="java.util.Collection"></jsp:useBean>
        <jsp:useBean id="listeCouturiers" scope="request" class="java.util.Collection"></jsp:useBean>
        <title>Saisir un nouveau défilé</title>
    </head>
    <body>
        <h1>Créer un nouveau défilé</h1>
        <form method="get" action="Menu">
            <fieldset>
                <legend>Informations Défilé</legend>
                    <label for="dateDefile">Date du défilé<span class="requis">*</span></label>
                    <input type="date" name="dateDefile" value="" size="20" maxlength="20"/>
                <br/>
                <br/>
                    <label for="nom">Nom<span class="requis">*</span></label>
                    <input type="text" name="nom" value="" size="20" maxlength="20"/>
                <br/>
                    <label for="lieu">Choisir un Lieu</label>
                    <select name ="lieu">
                        <option value="null"></option>
                        <% Collection<Lieu> lesLieux = listeLieux;
                            for(Lieu l : lesLieux){
                        %>
                            }
                            <option value="<%= l.getId() %>"><%= l.getNom() %></option>
                        <% } %>
                    </select>
                <br/>
                    <label for="couturier">Choisir un Couturier<span class="requis">*</span></label>
                    <select name="couturier">
                        <option value="null"></option>
                    <% Collection<Couturier> lesCout = listeCouturiers;
                            for(Couturier c : lesCout){
                        %>
                            }
                            <option value="<%= c.getId() %>"><%= c.getNom() %></option>
                        <% } %>
                    </select>
                <br/>
       
                    <%-- permet de passer la valeur du paramètre "action" pour Servlet --%>
                    <input type="hidden" name="action" value="creerDefile">
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
