<%-- 
    Document   : form
    Created on : 6 déc. 2023, 14:11:56
    Author     : tiavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="post" action="newServlet">
            <input type="text" name="nom" placeholder="Nom ..."/>
            <input type="text" name="prenom" placeholder="Prenom ..."/>
            <button type="submit">Valider</button>
        </form>
    </body>
</html>
