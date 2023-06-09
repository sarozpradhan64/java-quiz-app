<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Answer</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
body {
  width: 100%;
  min-height: 100vh;

  display: flex;
  justify-content: center;
  align-items: center;

  margin: 0;
  padding: 0;

  font-family: 'Segoe UI', -apple-system, BlinkMacSystemFont, sans-serif;
}


/* section */
section {
  width: 50%;
  min-height: inherit;

  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;

  position: relative;
}

section::before,
section::after {
  content: "";
  display: block;

  border-radius: 100%;

  position: fixed;
}





.light {
  --primary: hsl(250, 100%, 44%);
  --other: hsl(0, 0%, 14%);

  background: hsl(0, 0%, 98%);
}



/* h1 */
h1 {
  color: var(--other);
  padding: 8px 4px;
  border-bottom: 2px solid var(--other);
}


/* label */
label {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  flex-wrap: nowrap;

  margin: 12px 0;

  cursor: pointer;
  position: relative;
}


/* input */
input {
  opacity: 0;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  z-index: -1;
}


/* .design */
.design {
  width: 16px;
  height: 16px;

  border: 1px solid var(--other);
  border-radius: 100%;
  margin-right: 16px;

  position: relative;
}

.design::before,
.design::after {
  content: "";
  display: block;

  width: inherit;
  height: inherit;

  border-radius: inherit;

  position: absolute;
  transform: scale(0);
  transform-origin: center center;
}

.design:before {
  background: var(--other);
  opacity: 0;
  transition: .3s;
}

.design::after {
  background: var(--primary);
  opacity: .4;
  transition: .6s;
}


/* .text */
.text {
  color: var(--other);
  font-weight: bold;
}


/* checked state */
input:checked+.design::before {
  opacity: 1;
  transform: scale(.6);
}


/* other states */
input:hover+.design,
input:focus+.design {
  border: 1px solid var(--primary);
}

input:hover+.design:before,
input:focus+.design:before {
  background: var(--primary);
}

input:hover~.text {
  color: var(--primary);
}

input:focus+.design::after,
input:active+.design::after {
  opacity: .1;
  transform: scale(2.6);
}

.abs-site-link {
  position: fixed;
  bottom: 20px;
  left: 20px;
  color: hsla(0, 0%, 0%, .6);
  background: hsla(0, 0%, 98%, .6);
  font-size: 16px;
}

iframe{
border:none;
width:700px;
height:auto;}
</style>


</head>
<body>
	
	
	
	
	
<section class="light">
<form action = "${pageContext.request.contextPath}/TestController" method="POST">

<h5 style="color:blue">${NOTIFICATION}</h5>

  <h1>${quiz.question}</h1>

  <label>
    <input type="radio" name="light"  value = "${quiz.opt1}">
    <span class="design"></span>
    <span class="text">${quiz.opt1}</span>
  </label>

  <label>
    <input type="radio" name="light"  value = "${quiz.opt2}">
    <span class="design"></span>
    <span class="text">${quiz.opt2}</span>
  </label>

  <label>
    <input type="radio" name="light"  value = "${quiz.opt3}">
    <span class="design"></span>
    <span class="text">${quiz.opt3}</span>
  </label>
  
  <label>
    <input type="radio" name="light"  value = "${quiz.opt4}">
    <span class="design"></span>
    <span class="text">${quiz.opt4}</span>
  </label>
  <input type = "hidden" class = "form-control" name = "correct" placeholder = "Enter Correct answer" value = "${quiz.correct}"/>
  	<input type = "hidden" name = "id" value = "${quiz.id}" name="id"/>
  	<button type = "submit" class = "btn btn-primary">Check answer</button>
  	</form>
  	<a href = "${pageContext.request.contextPath}/TestController?action=LIST">Back to List</a>
	

</section>
	












 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>