<%@ page pageEncoding="UTF-8" %>
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
        <p>Nom : ${ contact.nomContact }</p>
        <p>Prénom : ${ contact.prenomContact }</p>
        <p>Email : ${ contact.emailContact }</p>
    </body>
</html>