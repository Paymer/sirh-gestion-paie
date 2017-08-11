<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAIE</title>
<link rel="stylesheet" href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'> </c:url>">
</head>
<body>

		<!-- Barra de Navegacion -->
<nav class="navbar navbar-default">
<div class="collapse navbar-collapse" id="maNavBar">
 <ul class="nav navbar-nav">
 		<sec:authorize access="hasRole('ROLE_ADMINISTRATEUR')">
			<li><a href='<c:url value="/mvc/employes/creer/"></c:url>'><span aria-hidden="true"></span> Creer Employe</a></li>
		</sec:authorize>
 	
 	<li><a href='<c:url value="/mvc/employes/lister/"></c:url>'><span aria-hidden="true"></span> Lister Employés</a></li>
 	
 		<sec:authorize access="hasRole('ROLE_ADMINISTRATEUR')">
			<li><a href='<c:url value="/mvc/bulletins/creer/"></c:url>'><span aria-hidden="true"></span> Creer Bulletin</a></li>
		</sec:authorize>
  	
  	<li><a href='<c:url value="/mvc/bulletins/lister/"></c:url>'><span aria-hidden="true"></span> Lister Bulletins</a></li>
</ul>
</div>
</nav>

	<h1>SIRH - Gestion de la paie</h1>
	
	<p> With the "user" credentials there will appear only the options of list for employees and for bulletin</p>
	<li><a></span> Lister Employés</a></li>
	<li><a></span> Lister Bulletins</a></li>
	
	<p>in case the "admin" credentials are used there will be show 4 options</p>
		<li><a></span> Creer Employé</a></li>
		<li><a></span> Lister Employés</a></li>
		<li><a></span> Creer Bulletin</a></li>
		<li><a></span> Lister Bulletins</a></li>
	
	
</body>
</html>

