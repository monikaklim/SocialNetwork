<!DOCTYPE html>

<html>
<head>
<title>Registrazione</title>

<link href="${pageContext.request.contextPath}/resources/css/registrazionestyle.css" rel="stylesheet">
    
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body>

<h3>Inserisci i tuoi dati</h3>

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
<td> <input type = "date" name = "data" max = "2004-12-31" placeholder = "yyyy-mm-dd"/></td>
</tr><tr>
<td>Username:</td>
<td> <input type = "text" name = "username" /></td>
</tr>
<tr>
<td>Password:</td>
<td> <input type = "password" name = "password" id = "pass"/></td>
<td><input type="checkbox" onclick="mostraPassword()">Mostra Password</td>
</tr>
<tr>
<td></td>
<td> <br><input class = "button" type = "submit" value = "Conferma" /></td>
</tr>

</table>

<script>

function mostraPassword() {
	  var x = document.getElementById("pass");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}

</script>

</form>

<a id = "homelink" href= ""><i class="material-icons">home</i></a>


</body>
</html>
