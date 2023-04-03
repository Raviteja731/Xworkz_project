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
<h1>Award Details....</h1>

<table class="table caption-top">
			<caption>Details of Award</caption>
			<thead>
				<tr>
					<th>id</th>
					<th>awardName</th>
					<th>awardMadeBy</th>
					<th>firstReciverName</th>
					<th>recivedDate</th>
					<th>givenBy</th>
					<th>Recived</th>
					<th>Not_Recived</th>
					<th>Edit</th>
					<th>Delete</th>



				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="r">
					<tr>
						<th scope="row">${r.id}</th>
						<td>${r.awardName}</td>
						<td>${r.awardMadeBy}</td>
						<td>${r.firstReciverName}</td>
						<td>${r.recivedDate}</td>
						<td>${r.givenBy}</td>
						<td>${r.isRecived()}</td>
						<td>${r.isNot_Recived()}</td>
						<td><a href="update?id=${r.id}">Edit</a></td>
						<td><a href="delete?id=${r.id}" class="btn btn-danger"}>Delete</a></td>
					</tr>
				</c:forEach>


			</tbody>
		</table>

</body>
</html>