<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<form action="${pageContext.request.contextPath}/LoginController" method="post">
<div class="card" style="width:400px">
<div class="card-header"> Admin Login</div>
<div class="card-body">

Email : <input type="text" name ="email"class="form-control" placeholder="Email" required/><br>
password : <input type="password" name ="password" class="form-control" placeholder="Password" required/> <br>
</div>
<div class="card-footer">
<input type="submit" value ="login" class="btn btn-primary"/>
</div>
</div>

</form>
</div>
</body>
</html>