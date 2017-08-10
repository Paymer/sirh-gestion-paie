<%@page import="dev.paie.entite.RemunerationEmploye"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Employés</title>
	<link rel="stylesheet" href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'> </c:url>">
</head>
<body>
	
		<!-- Barra de Navegacion -->
<nav class="navbar navbar-default">
<div class="collapse navbar-collapse" id="maNavBar">
 <ul class="nav navbar-nav">
 	<li><a href='<c:url value="/mvc/employes/creer/"></c:url>'><span aria-hidden="true"></span> Creer Employe</a></li>
 	<li><a href='<c:url value="/mvc/employes/lister/"></c:url>'><span aria-hidden="true"></span> Lister Employés</a></li>
  	<li><a href='<c:url value="/mvc/bulletins/creer/"></c:url>'><span aria-hidden="true"></span> Creer Bulletin</a></li>
  	<li><a href='<c:url value="/mvc/bulletins/lister/"></c:url>'><span aria-hidden="true"></span> Lister Bulletins</a></li>
</ul>
</div>
</nav>

	
	<h1>Liste des employés</h1>
	<!--     -->


            <section>
      <table ALIGN="CENTER" BORDER="2">
        <thead>
            <tr>
                <th ALIGN="CENTER"> Date/Heure création </th>
                <th ALIGN="CENTER"> Matricule </th>
                <th ALIGN="CENTER"> Grade </th>

            </tr>   
        </thead>
        <tbody>
		
<c:forEach var="empl" items="${remu}">

<tr>
<td> ${empl.dateCreation} </td>
<td> ${empl.matricule} </td>
<td> ${empl.grade.code} </td>

</tr>

</c:forEach>	
		
	</tbody>
	</table>
 	</section> 	
                
 
	
</body>
</html>