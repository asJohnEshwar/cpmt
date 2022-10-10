<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login JSP sample</title>
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
<!-- <link href="/css/style.css" type="text/css" rel="stylesheet"/> -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
	<!-- partial:index.partial.html -->

	<div class="login-form">
		<form action="servlet/userLogin" method="post">
			<h1>Login</h1>
			<div class="content">
				<div class="input-field">
					<input type=text placeholder="Username" autocomplete="nope"
						name="username">
				</div>
				<div class="input-field">
					<input type="password" placeholder="Password"
						autocomplete="new-password" name="password">
				</div>
				<a href="#" class="link">Forgot Your Password?</a>
			</div>
			<div class="action">
			
					
				<button type="button" id="reg"  >Register</button>
	
      			<button type="submit">Sign in</button>
    		
			
			</div>
		</form>
	
	</div>
	<!-- partial -->
	<script type="text/javascript">
	document.getElementById("reg").onclick = function () {
	     location.href = "signup.jsp";
	};</script>
	<script src="./script.js"></script>

</body>
</html>
