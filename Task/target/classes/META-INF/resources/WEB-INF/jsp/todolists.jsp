<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/5.2.0/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>

<nav class="navbar navbar-expand-md navbar-light bg-light  mb-3 p-1 container">
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
	<h1 class="text-center" >Your Todos</h1>

	<table class="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Description</th>
				<th>Date</th>
				<th>Done?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${todo}" var="todos">
				<tr>
					<td>${todos.id}</td>
					<td>${todos.discription}</td>
					<td>${todos.targetDate}</td>
					<td>${todos.done}</td>
					<td><a href="updatetodo?id=${todos.id}" class="btn btn-success">Update</a></td>
					<td><a href="deletetodo?id=${todos.id}" class="btn btn-warning">Remove</a></td>
					
				</tr>

			</c:forEach>

		</tbody>

	</table>
<div>	<a href="add-todo" class="btn btn-success">Add Todo</a> </div>
	</div>
	<script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
  <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>