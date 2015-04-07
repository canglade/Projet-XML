<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import = "Beans.Contact" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
<link id="bs-css" href="cssCharisma/bootstrap-cerulean.min.css" rel="stylesheet">
<link href="cssCharisma/charisma-app.css" rel="stylesheet">
<link href='cssCharisma/chosen.min.css' rel='stylesheet'>
<link href='cssCharisma/colorbox.css' rel='stylesheet'>
<link href='cssCharisma/responsive-tables.css' rel='stylesheet'>
<link href='cssCharisma/bootstrap-tour.min.css' rel='stylesheet'>
<link href='cssCharisma/jquery.noty.css' rel='stylesheet'>
<link href='cssCharisma/noty_theme_default.css' rel='stylesheet'>
<link href='cssCharisma/elfinder.min.css' rel='stylesheet'>
<link href='cssCharisma/elfinder.theme.css' rel='stylesheet'>
<link href='cssCharisma/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='cssCharisma/uploadify.css' rel='stylesheet'>
<link href='cssCharisma/animate.min.css' rel='stylesheet'>
</head>

<body onLoad="document.forms[0].submit();">
<form method="get" action="AfficherContacts">
<div class="row">
<div class="box col-md-12">
<div class="box-content">
<div class="alert alert-info" align="center">Liste des contacts </div>
<table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
	<thead>
		<tr>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Email</th>
			<th>Liste d'amis</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="contact" items="${contacts}">
			<tr>
				<td id="nomContact">${contact.getNomContact()}</td>
				<td class="center" id="prenomContact" >${contact.getPrenomContact()}</td>
				<td class="center" id="emailContact"><span class="label-success label label-default">${contact.getEmailContact()}</span></td>
				<td class="center">none</td>
				<td class="center">
					<a class="btn btn-success" href="CreationContact">Afficher Profil</a>
					<a class="btn btn-info" href="#">Modifier</a>
					<a class="btn btn-danger" href="#">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</div>
</div>
 
<script src="jsCharsima/jquery.min.js"></script>
<script src="jsCharisma/bootstrap.min.js"></script>
<script src="jsCharisma/jquery.cookie.js"></script>
<script src='jsCharisma/moment.min.js'></script>
<script src='jsCharisma/fullcalendar.min.js'></script>
<script src='jsCharisma/jquery.dataTables.min.js'></script>
<script src="jsCharisma/chosen.jquery.min.js"></script>
<script src="jsCharimsa/jquery.colorbox-min.js"></script>
<script src="jsCharisma/jquery.noty.js"></script>
<script src="jsCharisma/responsive-tables.js"></script>
<script src="jsCharima/bootstrap-tour.min.js"></script>
<script src="jsCharisma/jquery.raty.min.js"></script>
<script src="jsCharisma/jquery.iphone.toggle.js"></script>
<script src="jsCharisma/jquery.autogrow-textarea.js"></script>
<script src="jsCharisma/jquery.uploadify-3.1.min.js"></script>
<script src="js/jquery.history.js"></script>
<script src="js/charisma.js"></script>
</div>
</form>
</body>
</html>