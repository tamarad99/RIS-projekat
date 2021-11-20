<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://bootswatch.com/3/flatly/bootstrap.min.css" rel="stylesheet" type="text/css"> 

<title>Svi filmovi</title>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/Film/onama.jsp">O nama</a>
       <a class="navbar-brand" href="/Film/auth/getSveFilmove">Prikaz filmova</a>
        <a class="navbar-brand" href="/Film/auth/loginPage">Prijava</a>
       <a class="navbar-brand" href="/Film/prikazFilmaPoImenu.jsp">Pretraga filma</a>
        <security:authorize access="isAuthenticated()">
        	 <a class="navbar-brand" href="/Film/filmovi/UnosFilmaInit">Unos novog filma</a>
        	 <a class="navbar-brand" href="/Film/uloga/UnosUlogaInit">Unos nove uloge</a>
        	   <a class="navbar-brand" href="/Film/reports/Top10.pdf">Top 10-izvestaj</a>
        	   <a class="navbar-brand" href="/Film/reports/FilmoviOcenjeniIzmedju.pdf">Filmovi sa ocenom-izvestaj</a>
        	    <a class="navbar-brand" href="/Film/auth/logout">Odjava</a>
   </security:authorize>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
       <form class="navbar-form navbar-right" role="search" action="/Film/auth/getFilmByZanr?nazivZanra=${nazivZanra}" method="get">
        <div class="form-group">
          <input type="text" name="nazivZanra" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Pretrazi</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
      </ul>
    </div>
  </div>
</nav>

<div class="main">
	<img src="${pageContext.request.contextPath}/img/film_pocetna.jpg" class="center"/>
<div class="center" style="font-size:20px; text-align:left;">

<table class="table table-striped table-hover ">
  <thead>
			<tr class="active">
				<th>Slika</th>
				<th>Naslov</th>
				<th>Zanr</th>
				<th>Kategorija</th>
				<th>Reziser</th>
				<th>Trajanje(min)</th>
				<th>Ocena</th>
				<th>Uloge</th>
			</tr>
			<c:forEach items="${filmovi}" var="f">
				<tr class="active">
					<td><img src="/Film/auth/getSlikaFilma?idFilma=${f.idfilm}" height="80" width="60"/></td>
					<td>${f.naziv}</td>
					<td>${f.zanr.naziv}</td>
					<td>${f.kategorija.naziv}</td>
					<td>${f.reziser}</td>
					<td>${f.trajanje}</td>
					<td>${f.ocena.ocena}</td>
					<td><a href="/Film/auth/getUlogeFilma?idfilm=${f.idfilm}">Uloge</a></td>
				</tr>
			</c:forEach>
  </tbody>
		</div>
		</div>
</body>
</html>