<!doctype html>
<html>
<head>
<title>Reset password</title>
</head>

<body>



<form action = "processLogin" method = "POST" >
<table>
<tr>
<td>Nuova password:</td>
<td><input type = "password" placeholder = "Password" name = "password1" id="pass1" required/></td>
</tr> <tr>
<td>Conferma password:</td>
<td> <input type = "password" placeholder = "Password" name = "password2" id = "pass2" required/></td>




</tr><tr>
<tr>
<td> <br><input class = "button" onclick = "confronta()" value = "Conferma" /></td></tr>
</table>


<script>
function confronta(){
	var x = document.getElementById("pass1");
	var y = document.getElementById("pass2");
	
	if(x != y){
	alert("Le password non corrispondono");	
		
	}
	
}
</script>
</form>



</body>












</html>