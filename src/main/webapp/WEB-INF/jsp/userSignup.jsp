<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form method="POST" class="form-horizontal" action="/adduser">
<div class="User Signup page">
<h2>Sign up for user</h2>

<p>First Name</p>
<input type="text"name"" id="fname" placeholder="Enter first name" name="fname" >
<p>Last Name</p>
<input type="text"name""  id="lname" placeholder="Enter last name" name="lname">
<p>Username</p>
<input type="text"name""  id="email" placeholder="Enter email id" name="email">
<p>Password</p>
<input type="password"name"" id="pwd" placeholder="Enter password" name="pwd">
<p></p>
<button type="submit" class="btn btn-default">Submit</button>
<input type="submit"name"" value="Cancle">

</div>
</form>
</body>
</html>