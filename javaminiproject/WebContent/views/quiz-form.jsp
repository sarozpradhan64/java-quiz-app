<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Question</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	
	<div class = "container">
	
		<h1>Quiz Questions</h1>
		<hr/>
		
		<div class = "row">
		<div class="p-5">
				<form action = "${pageContext.request.contextPath}/Controller" method="POST">
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "question" placeholder = "Enter question" value = "${quiz.question}"/>
					</div>
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "opt1" placeholder = "Enter Option1" value = "${quiz.opt1}"/>
					</div>
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "opt2" placeholder = "Enter Option2" value = "${quiz.opt2}"/>
					</div>
				
				<div class = "form-group">
						<input type = "text" class = "form-control" name = "opt3" placeholder = "Enter Option3" value = "${quiz.opt3}"/>
					</div>
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "opt4" placeholder = "Enter Option4" value = "${quiz.opt4}"/>
					</div>
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "correct" placeholder = "Enter Correct answer" value = "${quiz.correct}"/>
					</div>
				
				
				
				
				
				
				
				
					<input type = "hidden" name = "id" value = "${quiz.id}" />
				
					<button type = "submit" class = "btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		<a href = "${pageContext.request.contextPath}/Controller?action=LIST">Back to List</a>
	</div>
	
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>