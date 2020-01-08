
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
<td><input type = "text" placeholder = "Username" name = "username" required/></td>
</tr> <tr>
<td>Password:</td>
<td> <input type = "password" placeholder = "Password" name = "password" id = "pass" required/></td>
<td><input type="checkbox" onclick="mostraPassword()">Mostra Password</td>

</tr><tr>
<tr>
<td> <br><input class = "button" type = "submit" value = "Accedi" /></td></tr>
<tr></tr>
<tr></tr>
<tr>
<td></td>
<td><input class = "button" type = "button" onclick = "openForm()" value = "Password Dimenticata?" /></td>
</tr>

</table>
<br>
<p style = "font-size: 12px; color:#b30000"><i>  ${msg} </i></p>

<div id = "link">
<table>
<tr>
<td><a href= "registrazione">Registrati</a> </td>
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



<form id= "passDim">
<button class = "button" id = "close"> <i class="material-icons">close</i>  </button>
<br><br>
Inserisci la tua email: <input type = "text" placeholder = "Email" name = "mailPass"/>
<p>Sarà inviato un link per reimpostare la password.</p>
<br>
<input class = "button" type = "button" onclick = "closeForm()" value = "Invia" />



</form>

<script>
function openForm() {
	  document.getElementById("passDim").style.display = "block";
	}
function closeForm() {
	  document.getElementById("passDim").style.display = "none";
	}
</script>





</body>






</html>
