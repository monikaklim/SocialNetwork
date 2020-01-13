<!DOCTYPE html>

<html>
<head>
<title>New post</title>

<link href="${pageContext.request.contextPath}/resources/css/newpoststyle.css"
    rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">



</head>

<body>

<h3><b>Create new post</b></h3>

<div>
<form id = "newpost" action = "publishPost">
<textarea id ="inputtext" placeholder = "Scrivi qualcosa..." > </textarea>
<br>
<input class = "button" type ="submit" id = "pubblica" value = "Pubblica">
</form>

</div>




<a id = "homelink" href= "dashboard"><i class="material-icons">home</i></a>








</body>

</html>