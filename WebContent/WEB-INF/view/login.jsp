
<!DOCTYPE html>

<html>
<head>
<title>Login</title>

<link href="${pageContext.request.contextPath}/resources/css/loginstyle.css"
    rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>

<body>

<h3><b> Login </b></h3>

<form action = "processLogin" method = "POST" >
<table>
<tr>
<td>Username:</td>
<td><input type = "text" placeholder = "Username" name = "username" required/></td>
</tr> <tr>
<td>Password:</td>
<td> <input type = "password" placeholder = "Password" name = "password" id = "pass" required/></td>
<td><input type="checkbox" onclick="mostraPassword()">Mostra Password</td>
</tr><tr>
<tr>
<td> <br><input class = "button" type = "submit" value = "Conferma" /></td></tr>
</table>


<div id = "link">
<table>
<tr>
<td><a href= "registrazione">Registrati</a>  </td>
<td><a id = "homelink" href= ""><i class="material-icons">home</i></a></td></tr>

</table>
</div>



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


</body>






</html>
