<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<title>X-Workz</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
     width: 100%;
  }
}
</style>

</head>
<body>

<nav class="navbar navbar-green bg-dark">
		<div class="container-fluid">
			<img
				src="https://www.x-workz.in/Logo.png"
				class="img-fluid" alt="..." hight="150px" width="170px">

			<form class="d-flex">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search"> <a class="btn btn-outline-primary"
					href="index.jsp">Home</a>
			</form>
		</div>
	</nav>
	</div>

<h1 style="color: green;">${message}</h1>
	<h5 style="color: red;">${messag}<br>
		<c:forEach items="${errors}" var="e">${e.message}</c:forEach>
	</h5>
	
	<form action="signUp" method="post">
		<h3>Login Here</h3>
		
		<div class="container">
    		<h1>Sign Up</h1>
    		<p>Please fill in this form to create an account.</p>
    		<hr>
    		
		
		<label for="UserId"><b></b></label>
		<span id="nameError" style="color: red"></span>
		<span id="UserNameId" style="color: red"></span>
    	<input type="text" placeholder="Enter UserId" name="userId" id="userId" onchange="validName()"  required>
		<h5 style="color: orange;">${UserIdExist}</h5><br>
		
		
		<label for="email"><b></b></label>
		<span id="emailError" style="color: red"></span>
		<span id="EmailId" style="color: red"></span>
    	<input type="text" placeholder="Enter Email" name="email" id="EmailId" onchange="validEmail()" required>
		<h5 style="color: orange;">${EmailExisted}</h5><br>
		
		<label for="mobileNo"><b></b></label>
		<span id="mobileNumberError" style="color: red"></span>
		<span id="mobileNumber" style="color: red"></span>
    	<input type="text" placeholder="Enter MobileNo" name="mobileNo" id="MobileNo" onchange="validNo()" required>
		<h5 style="color: orange;">${MobileNoExist}</h5><br>
		
		<label for="psw"><b></b></label>
		<span id="passwordError" style="color: red"></span>
    	<input class="input-2" type="Password" placeholder="Enter Password" name="password" id="Password" onchange="validPassword()" autocomplete="current-password" required><br>
		
		
		<label for="conf-psw"><b></b></label>
		<span id="ConformPasswordError" style="color: red"></span>
    	<input type="Password" placeholder="Enter confirmPassword" name="confirmPassword" id="confirmPassword" onchange="validPassword()" required>
		<span id="ConformPasswordError" style="color: red"></span>
		
		<br>
		<label>
      	<input type="checkbox" name="aggried" id="aggriment" onclick="onconform()" style="margin-bottom:15px"> Remember me
    	</label>
		
		<p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>		
        	 
			<button type="submit" class="btn btn-success" disabled="true" id="submitid">SignUp</button>
		
		</form>	
	
	<script>	
	
				
	
	
				function onconform()
				{	
					var agree =	document.getElementById('aggriment');
					console.log(agree.checked);
						if(agree.checked)
						{
							document.getElementById('submitid').disabled=false;	
						}else{
							document.getElementById('submitid').disabled='disable';
							}
				}
				
				function validName()
				{
					var valid = document.getElementById('userId');
					var user = valid.value;
					console.log(user)
					if(user!=null&& user!=""&& user.length>5&& user.length<20)
						{
							console.log('valid userId')
							document.getElementById('nameError').innerHTML='';
						}else{
							console.log('Invalid UserId');
							document.getElementById('nameError').innerHTML='please Enter valid name, name should be min=5 & max=20';
						}
					const xhttp = new XMLHttpRequest();
					console.log('Running in Ajax');
					console.log(user);
					xhttp.open("GET", "http://localhost:8080/xworkz_teja_cm/userId/" + user);
					xhttp.send();
					xhttp.onload = function() {
						console.log(this);
						document.getElementById("UserNameId").innerHTML = this.responseText
					}
				}
				
				
				function validEmail()
				{
					var email = document.getElementById('EmailId');
					var valid = email.value;
					console.log(valid)
					if(valid!=null&& valid!=""&& valid.length>5&& valid.length<20)
						{
							console.log('valid Email')
							document.getElementById('emailError').innerHTML='';
						}else{
							console.log('Invalid Email');
							document.getElementById('emailError').innerHTML='please Enter valid Email, Email should be min=5 & max=20';
						}
					const xhttp = new XMLHttpRequest();
					console.log('Running in Ajax');
					console.log(valid);
					xhttp.open("GET", "http://localhost:8080/xworkz_teja_cm/" + valid);
					xhttp.send();
					xhttp.onload = function() {
						console.log(this);
						document.getElementById("EmailId").innerHTML = this.responseText
					}
				}
				
				
				function validNo()
				{
					
					var no = document.getElementById('MobileNo');
					var mobileNo = no.value;
					console.log(mobileNo);
					if(mobileNo!=null&& mobileNo!=""&& mobileNo.length==10)
						{
							console.log('valid mobileNo');
							document.getElementById('mobileNumberError').innerHTML='';
						}else{
							console.log('Invalid mobileNo');
							document.getElementById('mobileNumberError').innerHTML='Please Enter Valid mobile Number';
						}
					const xhttp = new XMLHttpRequest();
					console.log('Running in Ajax');
					console.log(mobileNo);
					xhttp.open("GET", "http://localhost:8080/xworkz_teja_cm/" + mobileNo);
					xhttp.send();
					xhttp.onload = function() {
						console.log(this);
						document.getElementById("mobileNumber").innerHTML = this.responseText
					}
				}
				
				function validPassword()
				{
					
					var pw = document.getElementById('Password');
					var password = pw.value;
					var cpw = document.getElementById('confirmPassword');
					var conformPassword = cpw.value;
					console.log('password');
					  if(password!=null&& password!=""&& password.length>6&& password.length<10)
						{
							if(password==conformPassword)
								{
									console.log('Both Passwords are same');
									document.getElementById('ConformPasswordError').innerHTML='';
								}else{
									console.log('Both Passwords are Different');
									document.getElementById('ConformPasswordError').innerHTML='please Enter Password & conformPassword Same';
								}
							console.log('password is valid');
							document.getElementById('passwordError').innerHTML='';
						 }else{
							 	console.log('password is Invalid');
								document.getElementById('passwordError').innerHTML='Please Enter Valid Password, Password should be min=6 & max=10';
						 }
				}
					
	</script>
					

	
</body>
</html>