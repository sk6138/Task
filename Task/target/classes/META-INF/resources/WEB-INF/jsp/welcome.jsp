<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
<link href="webjars/bootstrap/5.2.0/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>

<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1 container">
	<a class="navbar-brand m-1" href="">Task Controller</a>
	<div class="collapse navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/welcome">Home</a></li>
			
			<li class="nav-item"><a class="nav-link" href="/todolists">Todo</a></li>
		</ul>
	</div>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
	</ul>	
</nav>
<div class="container">
<h1>welcome  ${name}</h1>
<hr>
<h1><a href="todolists" class="btn btn-success">See Your TODO-Lists</a></h1>

</div>
<script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
  <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>