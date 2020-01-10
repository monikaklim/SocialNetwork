<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
<head>
<title>Home</title>

<link href="${pageContext.request.contextPath}/resources/css/loggedstyle.css"
    rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<body>
<div >

<table id = "barra">

<tr>

<td>
<table> 
<tr>
<td><a class = "nav"  href =""><i class="material-icons">home</i></a></td>
<td><a class = "nav" href =""><i class="material-icons">account_circle</i></a></td>
<td><a class = "nav" href =""><i class="material-icons">settings</i></a></td>

</tr>

</table>
</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td><% String username = request.getParameter("username"); %>
Benvenuto  <% out.println(username); %></td>
<td></td>
<td></td>
<td></td>
<td>
<table  id = "ricerca">
<tr><td><input id="cercainput" class="cerca" type="text" placeholder="Cerca"></td>
 <td><button class="cerca" id = "cercabutton" type="submit"><i class="material-icons">search</i></button></td>
</tr>
</table>
</td>
</tr>
</table>

</div>



</body>

</html>