<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</head>
<body>

<nav class="navbar navbar-green bg-dark">
			<div class="container-fluid">
				<img
					src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
					class="img-fluid" hight="80px" width="80px">

				<form class="d-flex" action="findByAwardName" method="get">
					<input class="form-control me-3" type="text" placeholder="Search"
						aria-label="Search" name="AwardName"> <input type="submit"
						value="Search">
					<a href="index.jsp" class="btn btn-primary">Home</a>


				</form>

			</div>
		</nav>
	
		<h1>Update the Award Details details</h1>

	<c:forEach items="${err }" var="V">
		<span style="color: red">${V.message}</span>

	</c:forEach>

	<span style="color: green">${msg }</span>
	

	<form action="update" method="post">

	<div>
			<div class="mb-1">
				<label for="exampleFormControlInput1" class="form-label">Id
					</label> <input type="text" " class="form-control"
					id="exampleFormControlInput1" value="${dto.id}" readonly
					name="id" />
			</div>

		<div>
			<div class="mb-1">
				<label for="exampleFormControlInput1" class="form-label">Award
					Name</label> <input type="text" " class="form-control"
					id="exampleFormControlInput1" value="${dto.awardName}" placeholder="Enter Award Name"
					name="awardName" />
			</div>
			<div class="mb-2">
				<label for="exampleFormControlInput1" class="form-label">Award
					MadeBy</label> <input type="text" " class="form-control"
					id="exampleFormControlInput1" value="${dto.awardMadeBy}"  placeholder="Enter Award MadeBy"
					name="awardMadeBy" />
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">First
					Recived</label> <input type="text" " class="form-control"
					id="exampleFormControlInput1"
					placeholder="Enter First Reciver Name" value="${dto.firstReciverName}" name="firstReciverName" />
			</div>
			<div class="mb-4">
				<input type="radio" value="true" name="Recived">Recived <input
					type="radio" value="false"  name="Recived">Not-Recived
			</div>
			<div class="mb-5">
				<label for="exampleFormControlInput1" class="form-label">Recived
					Date</label> <input type=text " class="form-control"
					id="exampleFormControlInput1" value="${dto.recivedDate}" placeholder="Enter Recived Date"
					name="recivedDate">
			</div>
			<div>
				<label for="exampleFormControlInput1" class="form-label">Given
					By</label> <input type=text " class="form-control"
					id="exampleFormControlInput1" value="${dto.givenBy}" placeholder="Enter Given By"
					name="givenBy"> <input type="submit" value="update" />

			

	</form>
	

</body>
</html>