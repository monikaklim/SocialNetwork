<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<title>Password dimenticata</title>

<link href="${pageContext.request.contextPath}/resources/css/forgottenpasswordstyle.css"
    rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">



</head>
<body>
<a id = "homelink" href= ""><i class="material-icons">home</i></a>

<div id= "formPassDim">

<h2>Recupero password</h2>
<c:url  var ="resetLink" value = "/resetPassword" > 
						<c:param name="idUtente" value= "${idUtente}"/>
						</c:url>


<form action = "sendMailVerifica" >

Inserisci la tua email: <input type = "text" placeholder = "Email" name = "mailPass"/> <p id="confermaMailVerifica"></p>${controllo1}

<input class = "button" type = "submit" onclick = "showConfermaEmail()"  value = "Avanti" />
</form>
<br>
<br>


<div  id ="formCodice">
<form action = "controlloCodice" >

Ti sarà inviata una mail con un codice di verifica. Inseriscilo qui: <br><br>
 <input type = "number"  name = "codiceVerifica" required/>  ${controllo2}
<br>
<br>
<input class = "button" type = "submit" value = "Avanti" />
<br>
<br>
<br>
<p id = "conferma"></p>

</form>
</div>

<div  id ="formFine">
<form action = "sendMail">
<input class = "button" type = "submit"  value = "Fine" />${controllo3}
</form>
</div>

<script>
	
	
</script>
</div>



</body>


</html>