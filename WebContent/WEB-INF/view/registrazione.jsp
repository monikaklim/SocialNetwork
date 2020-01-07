
<!DOCTYPE html>

<html>
<head>
<title>Registrazione</title>

<link href="${pageContext.request.contextPath}/resources/css/registrazionestyle.css"
    rel="stylesheet">
</head>

<body>

<form action = "processRegistrazione" method = "POST" >

<table>
<tr>
<td>Nome:</td>
<td><input type = "text" name = "nome" /></td>
</tr> <tr>
<td>Cognome:</td>
<td> <input type = "text" name = "cognome" /></td>
</tr><tr>
<td>Data di nascita:</td>
<td> <input type = "date" name = "data" max = "currentDate" /></td>
</tr><tr>
<td>Username:</td>
<td> <input type = "text" name = "username" /></td>
</tr>
<tr>
<td>Password:</td>
<td> <input type = "password" name = "username" /></td>
</tr>
<tr>
<td></td>
<td> <br><input class = "button" type = "submit" value = "Conferma" /></td>
</tr>

</table>

</form>











</body>
</html>
