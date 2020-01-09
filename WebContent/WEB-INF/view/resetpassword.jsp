<%@ taglib prefix= "form" uri = "http://www.springframework.org/tags/form"  %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html>
<head>
<title>Reset password</title>

<link href="${pageContext.request.contextPath}/resources/css/resetstyle.css"
    rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>

<body>

<div>
<h4>Reset password</h4>
<form action = "confrontaPassword" >

<table>
<tr>
<td>Nuova password:</td>
<td><input type = "password" placeholder = "Password" name = "p1" required/></td>
</tr> <tr>
<td>Conferma password:</td>
<td> <input type = "password" placeholder = "Password" name = "p2" required/></td>
</tr>
<tr><td></td></tr>
<tr>
<td></td>
<td> <br><input class = "button" type = "submit" value = "Conferma" /></td></tr>
</table>



<input style="display:none" type = text  value = "${param.idUtente}" name = "idUtente" />
</form>
</div>
</body>



</html>