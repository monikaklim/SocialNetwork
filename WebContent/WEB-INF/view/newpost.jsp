<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
<head>
<title>New post</title>

<link href="${pageContext.request.contextPath}/resources/css/newpoststyle.css"
    rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">



</head>

<body>

<div>
<h3><b>Nuovo post <i class="material-icons">edit</i>   </b></h3>

<form id = "newpost" action = "publishPost"  method = "post" enctype = "multipart/form-data">
<textarea placeholder= "Scrivi qualcosa..."  name = "inputtext" id ="inputtext" > </textarea>
<br>
<input class = "button" type ="submit" id = "pubblica" value = "Pubblica">

<br>
<b>Carica una foto:</b> <br>
<i style ="font-size:25px;" class="material-icons">add_a_photo</i>
<input type = "file" name = "file" id = "inputfile" accept="image/*"  /> 


 <input style="display:none" type = text  value = "${param.idUtente}" name = "idUtente" />     

</form>

</div>




<a title= "Dashboard" onclick = "if(!(confirm('Vuoi annullare la creazione del post?'))) return false" id = "homelink" href= "dashboard"><i class="material-icons">home</i></a>




</body>

</html>