<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME|Quiz App</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial;
  color: white;
  
}

.split {
  height: 100%;
  width: 50%;
  position: fixed;
  z-index: 1;
  top: 0;
  overflow-x: hidden;
  padding-top: 20px;
}

.left {
  left: 0;
  background-color: #111;
    background-image: linear-gradient(rgba(0,0,0,0.5), rgba(0,0,0,0.5)),url("files/brain.png");
    
}

.right {
  right: 0;
   background-image: linear-gradient(rgba(0,0,0,0.5), rgba(0,0,0,0.5)),url("files/brain.png");
  
}

.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
}
.title{
positon: relative;
Padding: 30px;}
.title h1{
font-size: 50px;}


</style>
</head>
<body>

<div class="split left">
  <div class="centered">
<button type="button" class="btn btn-primary btn-lg" onclick="window.location.href = 'views/login.jsp'">Admin Login</button>

  
  </div>
  <div class=title>
<h1> Quiz App </h1>
</div>
</div>

<div class="split right">
  <div class="centered">
    <form class="form-inline" action = "${pageContext.request.contextPath}/TestController" >
  <div class="form-group mb-2">
  
  <div class="form-group mx-sm-3 mb-2">
   
    <input type="text" class="form-control" name="student" placeholder="Enter your Name" required>
  </div>

  <input type="submit" class="btn btn-primary mb-2" value="Student Login">
</form>
   
  </div>
</div>
     
</body>
</html> 
