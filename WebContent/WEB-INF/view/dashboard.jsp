<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
<head>
<title>Home</title>

<link href="${pageContext.request.contextPath}/resources/css/dashboardstyle.css"rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href='https://fonts.googleapis.com/css?family=Didact Gothic' rel='stylesheet'>
</head>
<body>
<div id= "nav">
<a title= "Logout" id = "escilink" href =""><i class="material-icons">highlight_off</i></a>
<a title= "Impostazioni" id ="settingslink" href =""><i class="material-icons">settings</i></a>

<a title= "Dashboard" href ="dashboard"><i class="material-icons">home</i></a>

<a title= "Account" href =""><i class="material-icons">account_circle</i></a>

<a title= "Notifiche" href =""><i class="material-icons">notifications</i></a>

</div>

<div id = "bottomnav">

<c:url  var ="newpostlink" value = "/newPost" > 
						<c:param name="idUtente" value= "${idUtente}"/>
</c:url>
<a title= "Nuovo post" id ="newpostlink" href = "${newpostlink} "><i style = "font-size:35px; "class="material-icons">add_circle</i></a>

<input id = "idUtente" style="display:none" type = text  value = "${idUtente}" name = "idUtente" />




</div>


<div id = "postContainer">



<c:forEach var="post" items="${postlist}"  end="9" >

<table id ="tabellapost">

						<tr > <td id ="username">${post.utente.username} </td> </tr>
						<tr><td id = "contenutopost"> ${post.testo} </td></tr>
						
					<tr> <td id = "immaginepost"> <img src = "${post.immagine.path}${post.immagine.nome}.${post.immagine.extension }" onerror="this.style.display='none'" ></td> </tr>
					
					<tr id = "heart"> <td class = "dislike" >   <i onclick = "like(this)" class="material-icons">favorite</i>							
	<script>
function like(x) {
	 x.classList.toggle("like");	}
	</script>
                   </td></tr> 	

</table>
</c:forEach>











</div>











</body>

</html>