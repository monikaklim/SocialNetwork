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
<h3>Homepage social network</h3>
<div id= "form">
<p><b>Accedi </b></p>


<form action = "processLogin" method = "POST" >
<table>
<tr>
<td><p>Username:</p></td>
<td><input type = "text" placeholder = "Username" name = "username" required/></td>
</tr> <tr>
<td><p>Password:</p></td>
<td> <input type = "password" placeholder = "Password" name = "password" id = "pass" required/></td>
<td><input type="checkbox" onclick="mostraPassword()"><label>Mostra password</label></td>

<tr>
<td></td>
<td> <br><input style = "width:215px" class = "button" type = "submit" value = "Accedi" /></td></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr>
<td><a href="forgottenPassword" >Password dimenticata?</a></td>
<td><a href= "registration">Registrati</a> </td>
</tr>

</table>
<br>
<p style = "font-size: 12px; color:#b30000"><i>  ${msg} </i></p>




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



</div>








</body>






</html>
