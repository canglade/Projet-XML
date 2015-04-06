<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList, java.util.List"%>
<%@ page import = "Beans.Contact" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un contact</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <%-- Affichage de la chaîne "message" transmise par la servlet --%>
        <p class="info">${ message }</p>
        <%-- Puis affichage des données enregistrées dans le bean "contact" transmis par la servlet --%>
        
        <ul>
			<c:forEach var="elem" items="${contacts}">
  				<li>${elem}</li>
			</c:forEach>
		</ul>
		
    </body>
</html>