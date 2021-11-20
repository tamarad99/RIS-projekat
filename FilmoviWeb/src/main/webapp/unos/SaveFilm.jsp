<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje filma</title>

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


<div class="center1" style="font-size:18px; text-align:center;">
<img src="${pageContext.request.contextPath}/img/film_pocetna.jpg" class="image"/>

<form:form modelAttribute="filmI" action="/Film/filmovi/saveFilmImg" method="post" enctype="multipart/form-data">
  <fieldset>
    <legend style="font-size:25px;">Unesite podatke za film</legend>
    <div class="form-group" style="text-align:left;">
      <label for="staticEmail" class="col-sm-2 col-form-label" style="text-align:left;">Naziv</label>
      <br>
      <div class="form-group">
        <form:input type="text" path="naziv" name="naziv" class="form-control" id="staticEmail"/>
      </div>
    </div>
    
       
    <div class="form-group" style="text-align:left;">
      <label for="exampleInputEmail1">Reziser</label>
      <form:input type="text" class="form-control" path="reziser" name="reziser" id="exampleInputEmail1"/>
    </div>
    
     <div class="form-group" style="text-align:left;">
      <label for="exampleInputEmail1">Trajanje(min)</label>
      <form:input type="text" class="form-control" path="trajanje" name="trajanje" id="exampleInputEmail1"/>
    </div>
    <div class="form-group" style="text-align:left;">
      <label for="exampleInputEmail1">Ocena</label>
      <form:input type="text" class="form-control" path="ocena" name="ocena" id="exampleInputEmail1"/>
    </div>
    <div class="form-group" style="text-align:left;">
      <label for="exampleInputPassword1">Opis</label>
      <form:input type="text" path="opis" name="opis" class="form-control" id="exampleInputPassword1"/>
    </div>
    <div class="form-group" style="text-align:left;">
      <label for="exampleSelect1">Zanr</label>
      <select class="form-control" name="idzanr" itemLabel="naziv" id="exampleSelect1">
      	<c:forEach items="${zanrovi}" var="z">
      		<option value="${z.idzanr}">${z.naziv}</option>
      	</c:forEach>
      </select>
    </div>
    <div class="form-group" style="text-align:left;">
      <label for="exampleSelect1">Kategorija</label>
      <select class="form-control" name="idkategorija" items="${kategorije}" itemLabel="naziv" id="exampleSelect1">
      	<c:forEach items="${kategorije}" var="k">
      		<option value="${k.idkategorija}">${k.naziv}</option>
      	</c:forEach>
      </select>
    </div>
    <div class="form-group" style="text-align:left;">
      <label for="exampleInputFile">Odaberite sliku</label>
      <form:input type="file" path="slika" class="form-control-file" id="exampleInputFile" aria-describedby="fileHelp"/>
    </div>
    
    <button type="submit" class="btn btn-primary">Dodaj</button>
  </fieldset>
</form:form>

</div>

</body>
</html>