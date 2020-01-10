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

<a href =""><i class="material-icons">home</i></a>
<a href =""><i class="material-icons">account_circle</i></a>
<a href =""><i class="material-icons">settings</i></a>


<p id = "user">
<% String username = request.getParameter("username"); %>
Benvenuto  <% out.println(username); %>!</p>





</div>



</body>

</html>