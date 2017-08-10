<%@page import="dev.paie.entite.BulletinSalaire"%>
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

	
	<h1>Liste des Bulletins</h1>
	<!--     -->


            <section>
      <table ALIGN="CENTER" BORDER="2">
        <thead>
            <tr>
                <th ALIGN="CENTER"> Date/Heure création </th>
                <th ALIGN="CENTER"> Période </th>
                <th ALIGN="CENTER"> Matricule </th>
                <th ALIGN="CENTER"> Salaire Brut </th>
                <th ALIGN="CENTER"> Net Imposable </th>
                <th ALIGN="CENTER"> Net A Payer </th>
                <th ALIGN="CENTER"> Actions </th>

            </tr>   
        </thead>
        <tbody>
		
<c:forEach var="bul" items="${bulletin}">

<tr>
<td> ${bul.dateCreation} </td>
<td> ${bul.periode} </td>
<td> ${bul.remunerationEmploye.matricule} </td>
<td> MAP ${bul.} </td>
<td> MAP ${bul.} </td>
<td> MAP ${bul.} </td>
<td> Je sais pas comment faire </td>


</tr>

</c:forEach>	
		
	</tbody>
	</table>
 	</section> 	
                
 
	
</body>
</html>