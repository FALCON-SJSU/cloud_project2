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

	<div class="container">
		<h2>Register Your Company here!</h2>
		<!--  <form method="POST" class="form-horizontal" action="/uploadFiletoS3" enctype="multipart/form-data">-->
		<form method="POST" class="form-horizontal" action="/addCompany">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email"
						placeholder="Enter email" name="email">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd"
						placeholder="Enter password" name="pwd">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cname">Company
					Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cname"
						placeholder="Enter Comapny Name" name="cname">
				</div>
			</div>
			<!--    <div class="form-group">
      <label class="control-label col-sm-2" for="file">Upload File:</label>
      <div class="col-sm-10">          
        <input type="file" class="btn btn-default" id="file"  name="file"><br />
		<button type="submit" class="btn btn-default">Upload</button>
      </div>
    </div>-->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<!--    <button type="submit" class="btn btn-default">Submit</button> -->
					<!--      <a  class="btn btn-default" href="/addCompany">Submit </a> -->
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>


	<div class="container">
		<h5>File uploading</h5>
		<form method="POST" class="form-horizontal" action="/uploadFiletoS3"  enctype="multipart/form-data">
			<div class="form-group">
				<label class="control-label col-sm-2" for="file">Upload
					File:</label>
				<div class="col-sm-10">
					<input type="file" class="btn btn-default" id="file" name="file"><br />
					<button type="submit" class="btn btn-default">Upload</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>
