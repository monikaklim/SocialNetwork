<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix= "form" uri = "http://www.springframework.org/tags/form"  %>
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

<div id= "formPassDim">
<button class = "button" id = "close" onclick="closeForm()"> <i class="material-icons">close</i>  </button>
<br><br>

<c:url  var ="resetLink" value = "/resetPassword" > 
						<c:param name="idUtente" value= "${idUtente}"/>
						</c:url>


<form action = "sendMailVerifica" >

Inserisci la tua email: <input type = "text" placeholder = "Email" name = "mailPass"/>

<input class = "button" type = "submit" onclick = "openCode()"  value = "Avanti" />
</form>
<br>
<br>



<form action = "controlloCodice" id ="formCodice">

Ti è stata inviata una mail con un codice di verifica. Inseriscilo qui: <br><br>
 <input type = "number"  name = "codiceVerifica"/>  ${controllo}
<br>
<br>
<input class = "button" type = "submit"  onclick = "showConferma()" value = "Avanti" />
<br>
<br>
<br>
<p id = "conferma"></p>

</form>

<form action = "sendMail">
<input class = "button" type = "submit"  value = "Invia mail" />
</form>

<script>


function openForm() {
	  document.getElementById("formPassDim").style.display = "block";
	// document.getElementById("formCodice").style.display = "none";
	}
	
	function openCode(){
		 document.getElementById("formCodice").style.display = "block";	
	}
	
	
function closeForm() {
	  document.getElementById("formPassDim").style.display = "none";

	}
	
	function showConferma(){
		
		 document.getElementById("conferma").innerHTML = "Sarà inviato un link per reimpostare la password.";
	}
</script>
</div>














</body>






</html>
