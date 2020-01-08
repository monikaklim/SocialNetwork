<!DOCTYPE html>

<html>
<head>
<title>Registrazione</title>

<link href="${pageContext.request.contextPath}/resources/css/registrazionestyle.css" rel="stylesheet">
    
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
<td> <input type = "date" name = "data" max = "2004-12-31" /></td>
</tr><tr>
<td>Username:</td>
<td> <input type = "text" name = "username" /></td>
</tr>
<tr>
<td>Password:</td>
<td> <input type = "password" name = "password" /></td>
</tr>
<tr>
<td></td>
<td> <br><input class = "button" type = "submit" value = "Conferma" /></td>
</tr>

</table>

</form>

<a id = "homelink" href= ""><i class="material-icons">home</i></a>


</body>
</html>
