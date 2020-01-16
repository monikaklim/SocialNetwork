<%@ taglib prefix= "form" uri = "http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>

<html>
<head>
<title>Modifica Post</title>

<link href="${pageContext.request.contextPath}/resources/css/updatestyle.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>


<body>



<div>

<h3> Modifica Post</h3>

<form:form action = "processUpdate" modelAttribute = "post" method = "PUT">

<form:hidden path= "idPost"/>
<table>
<tr>
<td>
<form:textarea   path= "testo" placeholder= "Scrivi qualcosa..."  name = "inputtext" id ="inputtext" /> 
<br>
</td>
</tr>
<tr>

</tr><tr>
<td> <br><input class = "button"  type = "submit" value = "Salva" /></td></tr>
</table>
</form:form>

 <br><br> <br>
<a id = "homelink" href="dashboard"><i class="material-icons">home</i></a> 
</div>

</body>
</html>