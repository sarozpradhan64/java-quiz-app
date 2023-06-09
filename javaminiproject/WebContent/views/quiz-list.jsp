<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz App</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 
</head>
<body>
	
	<div class = "container">
		
		<h1>Quiz Questions</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/quiz-form.jsp'">Add question</button>
		</p>
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Question</th>
				<th>Opt1</th>
				<th>Opt2</th>
				<th>opt3</th>
				<th>opt4</th>
				<th>correct</th>
				<th>Modify</th>
			</tr>
			
			<c:forEach items="${list}" var="quiz">
			
				<tr>
					<td>${quiz.question}</td>
					<td>${quiz.opt1}</td>
					<td>${quiz.opt2}</td>
					<td>${quiz.opt3}</td>
					<td>${quiz.opt4}</td>
					<td>${quiz.correct}</td>
					<td> 
						<a href = "${pageContext.request.contextPath}/Controller?action=EDIT&id=${quiz.id}">Edit</a> 
						| 
						<a href = "${pageContext.request.contextPath}/Controller?action=DELETE&id=${quiz.id}">Delete</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

</body>
</html>