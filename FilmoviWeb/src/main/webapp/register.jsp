<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registracija</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/style.css">
<link href="https://bootswatch.com/3/flatly/bootstrap.min.css"
	rel="stylesheet" type="text/css">

</head>
<body>


	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/Film/onama.jsp">O nama</a> <a
					class="navbar-brand" href="/Film/auth/getSveFilmove">Prikaz
					filmova</a> <a class="navbar-brand" href="/Film/auth/findFilm">Pretraga
					filma</a>
				<security:authorize access="isAuthenticated()">
					<a class="navbar-brand" href="/Film/filmovi/UnosFilmaInit">Unos
						novog filma</a>
					<a class="navbar-brand" href="/Film/uloga/UnosUlogaInit">Unos
						nove uloge</a>
					<a class="navbar-brand" href="/Film/reports/Top10.pdf">Top
						10-izvestaj</a>
					<a class="navbar-brand"
						href="/Film/reports/FilmoviOcenjeniIzmedju.pdf">Filmovi sa
						ocenom-izvestaj</a>
					<a class="navbar-brand" href="/Film/auth/logout">Odjava</a>
				</security:authorize>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<form class="navbar-form navbar-right" role="search"
					action="/Film/auth/getFilmByZanr?nazivZanra=${nazivZanra}"
					method="get">
					<div class="form-group">
						<input type="text" class="form-control" name="nazivZanra"
							placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Pretrazi</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
				</ul>
			</div>
		</div>
	</nav>



	<div class="center1" style="font-size: 20px; text-align: center;">
		<img src="${pageContext.request.contextPath}/img/film_pocetna.jpg"
			class="image" />

		<sf:form modelAttribute="user" action="register" method="post">


			<fieldset>


				<c:if test="${param.error != null}">
					<div class="alert alert-dismissible alert-danger">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<p>Pogresni podaci.</p>
					</div>
				</c:if>


				<legend style="font-size: 35px;">Registracija</legend>
				<div class="form-group" style="text-align: left;">
					<label for="example">Ime</label>
					
					<sf:input type="text" path="ime" class="form-control"
						id="exampleInputPassword1" placeholder="Ime"/>
						
				</div>
				
				<form:errors path="ime" cssClass="errors"/>
				
				<div class="form-group" style="text-align: left;">
					<label for="example">Prezime</label>

					<sf:input type="text" path="prezime" class="form-control"
						id="exampleInputPassword1" placeholder="Prezime" />
				</div>
				
				<form:errors path="prezime" cssClass="errors"/>
				
				<div class="form-group" style="text-align: left;">
					<label for="example">Korisnicko ime</label>

					<sf:input type="text" path="korisnickoime" class="form-control"
						id="exampleInputPassword1" placeholder="korisnisko ime" />
				</div>
				
				<form:errors path="korisnickoime" cssClass="errors"/>
				
				<div class="form-group" style="text-align: left;">
					<label for="exampleInputPassword1">Sifra</label>
					<sf:input type="password" path="sifra" class="form-control"
						id="exampleInputPassword1" placeholder="Sifra" />
				</div>
				
				<form:errors path="sifra" cssClass="errors"/>
				
				<div class="form-group" style="text-align: left;">
					<label for="exampleSelect1">Uloga</label>
					<sf:select class="form-control" path="ulogas" items="${roles}"
						itemValue="iduloga" itemLabel="naziv" id="exampleSelect1" />
				</div>
				<button type="submit" class="btn btn-primary">Registruje se</button>
				<br> <br>
			</fieldset>
		</sf:form>


	</div>



</body>
</html>