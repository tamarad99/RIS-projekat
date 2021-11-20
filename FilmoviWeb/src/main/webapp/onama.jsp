<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://bootswatch.com/3/flatly/bootstrap.min.css" rel="stylesheet" type="text/css"> 
<title>O nama</title>
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
        <security:authorize access="isAuthenticated()">
             <a class="navbar-brand" href="/Film/prikazFilmaPoImenu.jsp">Pretraga filma</a>
        	 <a class="navbar-brand" href="/Film/unos/UnosKnjige.jsp">Unos novog filma</a>
        	 
        	   <a class="navbar-brand" href="/Film/reports/Top10.pdf">Top 10-izvestaj</a>
        	   <a class="navbar-brand" href="/Film/reports/FilmoviOcenjeniIzmedju.pdf">Filmovi sa ocenom-izvestaj</a>
        	    <a class="navbar-brand" href="/Film/auth/logout">Odjava</a>
   </security:authorize>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
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
<div class="center" style="font-size:35px; text-align:center;">
O nama:<br>
<br>
<br>
Ova stranica predstavlja internet bazu filmova. Ovde mozete pronaci filmove svih zanrova, kako strane tako i domace. 
Po ocenama koje su ostavili clanovi, mozete odluciti koji film je pravi izbor za Vas!
</div>
</div>
</body>
</html>