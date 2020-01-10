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


<div id= "formPassDim">

<h2>Recupero password</h2>
<c:url  var ="resetLink" value = "/resetPassword" > 
						<c:param name="idUtente" value= "${idUtente}"/>
						</c:url>


<form action = "sendMailVerifica" >

Inserisci la tua email: <input type = "text" placeholder = "Email" name = "mailPass"/>

<input class = "button" type = "submit"   value = "Avanti" />
</form>
<br>
<br>


<div  id ="formCodice">
<form action = "controlloCodice" >

Ti sarà inviata una mail con un codice di verifica. Inseriscilo qui: <br><br>
 <input type = "number"  name = "codiceVerifica" required/>  ${controllo}
<br>
<br>
<input class = "button" type = "submit"  onclick = "showConferma()" value = "Avanti" />
<br>
<br>
<br>
<p id = "conferma"></p>

</form>
</div>

<div  id ="formFine">
<form action = "sendMail">
<input class = "button" type = "submit"  value = "Fine" />
</form>
</div>

<script>


function openForm() {
	 document.getElementById("formPassDim").style.display = "block";
	}
	

	
	
	function showConferma(){
		
		 document.getElementById("conferma").innerHTML = "Sarà inviato un link per reimpostare la password.";
	}
</script>
</div>



</body>


</html>