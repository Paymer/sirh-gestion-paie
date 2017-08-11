<%@page import="dev.paie.entite.RemunerationEmploye"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>paie</title>
 <link rel="stylesheet" href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'> </c:url>">
</head>

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

<body>

<h1>Ajouter un employé</h1>

<form class="form-horizontal" method="post">
<fieldset>

<!-- Form Name -->
<legend>...</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Matricule">Matricule</label>  
  <div class="col-md-4">
  <input id="Matricule" name="Matricule" type="text" placeholder="Matricule" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Entreprise">Entreprise</label>
  <div class="col-md-4">
    <select id="Entreprise" name="Entreprise" class="form-control">
    <c:forEach var="ent" items="${entreprise}">
      <option>${ent.denomination}</option>
      </c:forEach>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Profil">Profil</label>
  <div class="col-md-4">
    <select id="Profil" name="Profil" class="form-control">
<c:forEach var="prof" items="${prof}">
      <option>${prof.code}</option>
      </c:forEach>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Grade">Grade</label>
  <div class="col-md-4">
    <select id="Grade" name="Grade" class="form-control">
	<c:forEach var="grad" items="${grad}">
      <option>${grad.code}</option>
      </c:forEach>
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group" ALIGN="RIGHT">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton"  name="singlebutton" class="btn btn-primary">Ajouter</button>
  </div>
  <!-- It is necessary to add this for the buttons -->
  <sec:csrfInput/>
</div>

</fieldset>
</form>


</body>
</html>