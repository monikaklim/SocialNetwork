<%@ taglib prefix= "form" uri = "http://www.springframework.org/tags/form"  %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>
<html>
<head>
<title>Reset password</title>
</head>

<body>



<form action = "confrontaPassword"  method = "post">

<table>
<tr>
<td>Nuova password:</td>
<td><input type = "password" placeholder = "Password" name = "p1" id="pass1" required/></td>
</tr> <tr>
<td>Conferma password:</td>
<td> <input type = "password" placeholder = "Password" name = "p2" id = "pass2" required/></td>
</tr><tr>
<tr> <td> <p id = "confronto"> </p>
<tr>
<td> <br><input class = "button" type = "submit" value = "Conferma" /></td></tr>
</table>




</form>
</body>




</html>