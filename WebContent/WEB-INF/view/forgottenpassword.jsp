
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix= "form" uri = "http://www.springframework.org/tags/form"  %>
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