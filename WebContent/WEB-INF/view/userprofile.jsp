<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
<head>
<title>Home</title>

<link href="${pageContext.request.contextPath}/resources/css/userprofilestyle.css"rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href='https://fonts.googleapis.com/css?family=Didact Gothic' rel='stylesheet'>
</head>

<body >


<div id= "nav">
<a title= "Logout" id = "escilink" href =""><i class="material-icons">highlight_off</i></a>
<a title= "Impostazioni" id ="settingslink" href =""><i class="material-icons">settings</i></a>
<a title= "Dashboard" href ="dashboard"><i class="material-icons">home</i></a>
<a title= "Profilo" href ="userProfile"><i class="material-icons">account_circle</i></a>
<a title= "Notifiche" href =""><i class="material-icons">notifications</i></a>
</div>

<div id = "bottomnav">


<c:url  var ="newpostlink" value = "/newPost" > 
						<c:param name="idUtente" value= "${sessionScope.utenteSession.idUtente}"/>
</c:url>
<a title= "Nuovo post" id ="newpostlink" href = "${newpostlink} "><i style = "font-size:35px; "class="material-icons">add_circle</i></a>

<input id = "idUtente" style="display:none" type = text  value = "${sessionScope.utenteSession.idUtente}" name = "idUtente" />

</div>

<div id = "pagecontainer"> 

<div id ="datiUtente">
<table>
<tr><td>Nome:</td>
<td class = "dati"> ${sessionScope.utenteSession.nome} </td>
</tr>

<tr><td>Cognome:</td>
<td class = "dati"> ${sessionScope.utenteSession.cognome} </td>
</tr>
<tr><td>Data di nascita:</td>
<td class = "dati"> ${sessionScope.utenteSession.dataNascita} </td>
</tr>

<tr><td>Email:</td>
<td class = "dati"> ${sessionScope.utenteSession.email} </td>
</tr>

<tr><td>Username:</td>
<td class = "dati"> @${sessionScope.utenteSession.username} </td>
</tr>
</table>

</div>


<div id = "listaamici">
<table>
<tr><td>Lista Amici </td></tr>

<c:forEach var="amici" items="${amici}" > 
<table>
 
<tr>
<td id = "useramico">@${amici.username}	</td>
		</tr>														


</table>
</c:forEach>

</table>
</div>



</div>
</body>

</html>