<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pocetna</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css">
<link href="https://bootswatch.com/3/flatly/bootstrap.min.css" rel="stylesheet" type="text/css"> 

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
             <a class="navbar-brand" href="/Film/prikazFilmaPoImenu.jsp">Pretraga filma</a>
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
<img src="${pageContext.request.contextPath}/img/slika1.jpg" class="center"/>
<div class="center" style="font-size:45px; text-align:center;">
Dobrodosli na stranicu!
</div>
</div>
</body>
</html>