<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
<head>
<title>Home</title>

<link href="${pageContext.request.contextPath}/resources/css/dashboardstyle.css"
    rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<body>
<div id= "nav">
<a id ="settingslink" href =""><i class="material-icons">settings</i></a>

<a href =""><i class="material-icons">home</i></a>

<a href =""><i class="material-icons">account_circle</i></a>

<a href =""><i class="material-icons">notifications</i></a>
<p id = "user"> <b>
<% String username = request.getParameter("username"); %>
Welcome
  <% out.println(username+"!"); %> </b></p>
</div>




<c:url  var ="newpostlink" value = "/newPost" > 
						<c:param name="idUtente" value= "${idUtente}"/>
						</c:url>
<a id ="newpostlink" href = "${newpostlink} "><i style = "font-size:35px; "class="material-icons">add_circle</i></a>



















</body>

</html>