<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Todo Page</title>
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
<h1>Enter Todo Details</h1>
<hr>


<form:form method="post" modelAttribute="todo">
  <div class="form-group">
  
   <fieldset>
   <h3><label for="desc" path="discription">Description</label></h3> 
    <form:input type="text" path="discription" class="form-control" id="desc" placeholder="Enter Description" required="required"/>
  
   <form:errors type="text" path="discription" cssClass="text-warning" />
   </fieldset>
   
   
   <fieldset>
   <label for="date" path="targetDate">Target Date</label>
    <form:input type="date" path="targetDate" class="form-control" id="targetDate" placeholder="Enter Date" required="required"/>
  
   <form:errors type="text" path="targetDate" cssClass="text-warning" />
   </fieldset>
   
    <fieldset>
   <h3><label for="done" path="done">Complete</label></h3> 
    <form:input type="text" path="done" class="form-control" id="done" placeholder="Enter True for completed" required="required"/>
  
   <form:errors type="text" path="done" cssClass="text-warning" />
   </fieldset>
   
    
   
   
   
      
    <form:input type="hidden" path="id" placeholder="Enter Description" required="required" />
    
  
     
    <form:input type="hidden" path="done" placeholder="Enter Description" required="required" />
    </div>
  
 <br>
  <button type="submit" class="btn btn-success">Submit</button>
</form:form>


</div>
<script src="webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
  <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
   
</body>
</html>