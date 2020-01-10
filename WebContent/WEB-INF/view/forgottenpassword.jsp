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

Inserisci la tua email: <input type = "text" placeholder = "Email" name = "mailPass"/> <p>${controllo1}</p>
<br>
<input class = "button" type = "submit"   value = "Avanti" />
</form>
<br>
<br>


<div  id ="formCodice">
<form action = "controlloCodice" >

Ti sarà inviato un codice di verifica per confermare la tua identità. Inseriscilo qui: <br><br>
 <input type = "number"  name = "codiceVerifica" required/> <p> ${controllo2}</p>
<br>
<br>
<input class = "button" type = "submit" value = "Avanti" />
<br>
<br>
<br>

</form>
</div>

<div  id ="formFine">
<form action = "sendMail">
<input class = "button" type = "submit"  value = "Fine" /><br><br>
<p>${controllo3}</p>
</form>

</div>

<script>
	
	
</script>
</div>



</body>


</html>