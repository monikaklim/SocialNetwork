<%@ taglib prefix= "form" uri = "http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>

<html>
<head>
<title>Modifica Post</title>

<link href="${pageContext.request.contextPath}/resources/css/updatestyle.css"
    rel="stylesheet">
</head>


<body>



<h3> Modifica Post</h3>
<div>


<form:form action = "processUpdate" modelAttribute = "post" method = "PUT">

<form:hidden path= "idPost"/>
<table>
<tr>
<td>
<form:input type="text"  path= "testo" placeholder= "Scrivi qualcosa..."  name = "inputtext" id ="inputtext" /> 
<br>
</td>
</tr>
<tr>
<td>
<form:input type="file" path = "immagine" name = "file" id = "inputfile" accept="image/*" />
</td>
</tr>
</table>
</form:form>

 <br><br> <br>
<a href="dashboard">Annulla</a> 
</div>

</body>
</html>