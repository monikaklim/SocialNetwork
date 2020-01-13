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
<h3><b>New post <i class="material-icons">edit</i>   </b></h3>

<form id = "newpost" action = "publishPost" method = post>
<textarea placeholder= "Scrivi qualcosa..."  name = "inputtext" id ="inputtext" > </textarea>
<br>
<input class = "button" type ="submit" id = "pubblica" value = "Pubblica">
</form>
<br>
<form action ="uploadImage" id ="uploadimage" method = "post" enctype = "multipart/form-data">

 <input type = "file" name = "file" size = "50" id = "inputfile" />
 <button  class = "button" id = "caricafoto" type = "submit" ><i class="material-icons">add_a_photo</i></button>
      

</form>




</div>




<a id = "homelink" href= "dashboard"><i class="material-icons">home</i></a>








</body>

</html>