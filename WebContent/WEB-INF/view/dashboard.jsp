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

<body >
<c:set var="idU" scope="application" value="${idUtente}"/>

<div id= "nav">
<a title= "Logout" id = "escilink" href =""><i class="material-icons">highlight_off</i></a>
<a title= "Impostazioni" id ="settingslink" href =""><i class="material-icons">settings</i></a>
<a title= "Dashboard" href ="dashboard"><i class="material-icons">home</i></a>
<a title= "Account" href =""><i class="material-icons">account_circle</i></a>
<a title= "Notifiche" href =""><i class="material-icons">notifications</i></a>
</div>

<div id = "bottomnav">


<c:url  var ="newpostlink" value = "/newPost" > 
						<c:param name="idUtente" value= "${idU}"/>
</c:url>
<a title= "Nuovo post" id ="newpostlink" href = "${newpostlink} "><i style = "font-size:35px; "class="material-icons">add_circle</i></a>

<input id = "idUtente" style="display:none" type = text  value = "${idU}" name = "idUtente" />




</div>


<div id = "postContainer">





<c:set var = "i" value = "${9}"/>
 <c:forEach var="post" items="${postlist}"  end= "${i}" varStatus = "loop" > 
<table id ="tabellapost">

						<tr > <td id ="username">${post.utente.username}  </td> </tr>
						
						
					
						<tr><td >
						
							<div class = "dropdown">
							<button id = "optionsbutton" onclick = "showOptions()"> <i class="material-icons">expand_more</i>  </button>
							<div id ="opzioni">
							<a href="deletePost"><i class="material-icons">delete</i>Elimina post</a>
							<a href="updatePost"><i class="material-icons">edit</i>Modifica post</a>
							
							</div>				
							</div>
											</td> </tr>
											
					
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



<c:forEach begin = "0" end = "${size-1}" > 

<div id= "moreposts" style = "display:none" >

 <c:forEach var="post" items="${postlist}" begin= "${i+1}" end= "${i+10}" > 
<table id ="tabellapost">
<tr > <td id ="username">${post.utente.username} </td> </tr>
						
						
						<tr><td id = "contenutopost"> ${post.testo} </td></tr>
					<tr> <td id = "immaginepost"> <img src = "${post.immagine.path}${post.immagine.nome}.${post.immagine.extension }" onerror="this.style.display='none'" ></td> </tr>
					
					
					
					
						<tr><td id = "deletepost">
							<form action = "deletePost">
							<button onclick = "deletePost"> <i class="material-icons">delete</i>  </button>

							</form>
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							
											</td> </tr>
					<tr id = "heart"> <td class = "dislike" >   <i onclick = "like(this)" class="material-icons">favorite</i>							
	<script>
function like(x) {
	 x.classList.toggle("like");}
	</script>
                   </td></tr> 	

</table>
</c:forEach>


<script>
function showMore() {
	 
	var x = document.getElementById("moreposts");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	  } 
	 }

</script>

</div>

</c:forEach>

<button id ="more" onclick = "showMore()" > <i class="material-icons" style = "font-size:25px;">more_horiz</i> </button>
</div>











</body>

</html>