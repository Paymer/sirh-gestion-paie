<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Paie - App</title>
<link rel="stylesheet" href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'> </c:url>">
</head>
<body class="container">
<h1>Sirh-gestion</h1>
<h3>Connexion</h3>
<!-- Spring Security s'attend aux paramètres "username" et "password" -->
<form method="post">
<input name="username" placeholder="username"><br></br>
<input name="password" placeholder="password"><br></br>
<div class="col-md-4">
    <button id="singlebutton"  name="singlebutton" class="btn btn-primary">Se Connecter</button>
  </div>
  <sec:csrfInput/>
</form>
<!-- en cas d'erreur un paramètre "error" est créé par Spring Security -->
<c:if test="${param.error !=null}">
Erreur d'authentification
</c:if>
</body>
</html>