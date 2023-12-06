<%@page import="java.util.List"%>
<%@page import="etudiant.Etudiant"%>
<%
       List<Etudiant> listeEmp =(List<Etudiant>)request.getAttribute("model");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        fdghjklmS
        <h1>Liste des etudiants</h1>
        <table border=1>
            <tr>
                <th>Id_Etudiant</th>
                <th>Nom</th>
                <th>Prenom</th>
            </tr>
            <% for(Etudiant e:listeEmp){%>
                 <tr>
                     <td><%=e.getIdEtudiant()%></td>
                     <td><%=e.getNom()%></td>
                <td><%=e.getPrenom()%></td>
            </tr>
            <% }%>
            
        </table>
    </body>
</html>
