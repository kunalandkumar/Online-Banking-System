<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Green Bank</title>
<link rel="shortcut icon" type="image/png" href="image/favicon.png" />
<link rel="stylesheet" type="text/css" href="css/main_css.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="row">
		<jsp:include page="header.jsp" />
	</div>
	<div class="container-fullwidth" style="margin-top: 0 px">
		<div class="row">
			<div class="col-md-12">
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<center>
						<p class="col-md-6 col-md-offset-3 text-center scheme-text">
						This Project is Done By the Team Below.<br>
						We Have Developed this Project Using The Technology That We Lean In this Period of Time.
						</p>
						</center>
				</div>
			</div>
		</div>
		<br>
		<br>
		<div class="row">
			<div class="schemes" style="margin-bottom: -155px;">
				<div class="col-md-3 scheme-type-1">
					<h2 class="text-center text-medium">
						KUNAL<br>
					</h2>
					<center>
					<img src="image/Kunal.jpg" alt="First slide"width="150" height="150"><br>
					</center>
					<p class="col-md-6 col-md-offset-3 text-center scheme-text"> Name-Kunal Kumar<br>
					Roll-No-18CSE203<br>Branch-CSE<br>Team Lead<br></p>
					<div class="scheme-button col-md-4 col-md-offset-4">
											</div>
				</div>
				<div class="col-md-3 scheme-type-2">
					<h2 class="text-center text-medium">
						ANKIT<br>
					</h2>
					<center>
					<img src="image/Ankit.jpg" alt="First slide" width="150" height="150"><br>
					</center>
					<p class="col-md-6 col-md-offset-3 text-center scheme-text">
					Name-Ankit Kumar Jena<br>
					Roll-No-18CSE153<br>Branch-CSE<br> <br>
					</p>
					<div class="scheme-button col-md-4 col-md-offset-4">
					
					</div>
				</div>
				<div class="col-md-3 scheme-type-3">
					<h2 class="text-center text-medium">
						VARSHIT<br>
					</h2>
					<center>
					<img src="image/Varshit.jpg" alt="First slide" width="150" height="150"><br></center>
					<p class="col-md-6 col-md-offset-3 text-center scheme-text">
						Name-P. Varshit Verma<br>
					Roll-No-18CSE138<br>Branch-CSE<br> <br> 
					</p>
					<div class="scheme-button col-md-4 col-md-offset-4">
						
					</div>
				</div>
				<div class="col-md-3 scheme-type-2">
					<h2 class="text-center text-medium">
						BHANU<br>
					</h2>
					<center>
					<img src="image/Bhanu.jpg" alt="First slide" width="150" height="150"><br></center>
					<p class="col-md-6 col-md-offset-3 text-center scheme-text">
						Name-Bhanu  Pratap Singh<br>
					Roll-No-18CSE157<br>Branch-CSE<br> <br>
					</p>
					<div class="scheme-button col-md-4 col-md-offset-4">
											</div>
				</div>
				
			</div>
		</div>

		<!-- Footer start here -->
		<div class="row" style="margin-top: 50px;">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>


</body>
</html>