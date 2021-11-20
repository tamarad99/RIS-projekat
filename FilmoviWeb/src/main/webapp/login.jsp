<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prijava</title>

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
          <input type="text" class="form-control" name="nazivZanra" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Pretrazi</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
      </ul>
    </div>
  </div>
</nav>



<div class="center1" style="font-size:20px; text-align:center;">
<img src="${pageContext.request.contextPath}/img/slika2.jpg" class="image"/>

<c:url var="loginUrl" value="/login" />



<form class="form-horizontal" action="${loginUrl}" method="post">
  <fieldset>
  
  <c:if test="${param.error != null}">
		<div class="alert alert-dismissible alert-danger">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
			<p>Pogresni podaci.</p>
		</div>
</c:if>

<c:if test="${param.logout != null}">
		<div class="alert alert-dismissible alert-success">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
			<p>Uspesno ste se odjavili.</p>
		</div>
</c:if>
  
    <legend style="font-size: 45px;">Prijava</legend>
    <div class="form-group" style="text-align:left;">
      <label for="example">Korisnicko ime</label>
        <input type="text"  name="username" class="form-control" id="inputEmail" placeholder="Unesite korisnicko ime" required>
    </div>
    <div class="form-group" style="text-align:left;">
      <label for="inputPassword">Sifra</label>
        <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Unesite sifru" required>
        <br>
        <div class="checkbox" align="left">
          <label>
            <input type="checkbox" name="remember-me" > Zapamti me
          </label>
        </div>
      </div>
    <div class="form-group" align="left">
      <div class="col-lg-10 col-lg-offset-2">
	<td><input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /></td>
	<div align="right">
        <button type="submit" class="btn btn-primary">Prijava</button>
    </div>
    <div class="form-group" align="left">
  Nemate nalog? <a href="/Film/auth/registerUser">Registrujte se</a>
  </div>
      </div>
    </div>
  </fieldset>
  <br>
  
  <br>
  <br>
</form>

</div>
</body>
</html>