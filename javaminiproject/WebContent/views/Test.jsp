<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Test</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>



	<div class = "container">
		
		<h1>Quiz Questions</h1>
		<hr/>
		
		<h5>${student}</h5>
		
		
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Questions List</th>
				<th>View</th>
				
			</tr>
			
			<c:forEach items="${list}" var="quiz">
			
				<tr>
					<td>${quiz.question}</td>
				
				
					<td> 
					
						|  
						<a href = "${pageContext.request.contextPath}/TestController?action=answer&id=${quiz.id}"><button class = "btn btn-primary">Give answer</button></a>|
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

























