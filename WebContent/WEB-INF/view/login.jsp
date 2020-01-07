<!DOCTYPE html>

<html>
<head>
<title>Login</title>

<link href="${pageContext.request.contextPath}/resources/css/loginstyle.css"
    rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>

<body>

<h3><b> Login </b></h3>


<form action = "processLogin" method = "POST" >

<table>
<tr>
<td>Username:</td>
<td><input type = "text" name = "username" /></td>
</tr> <tr>
<td>Password:</td>
<td> <input type = "password" name = "password" /></td>
</tr><tr>
<td> <br><input class = "button" type = "submit" value = "Accedi" /></td>
</tr>

</table>

</form>













</body>

</html>
