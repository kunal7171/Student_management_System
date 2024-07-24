<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<style type="text/css">
.enroll {
	background-image: url("images/b.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}

.heading {
	font-family: cursive;
	text-align: center;
	margin-bottom: 20px;
}

form {
	width: 400px
}

.view {
	background-image: url("images/c.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}
</style>


</head>
<body>
	<div class="card">
		<nav class="d-flex justify-content-between p-2 border border-primary">
			<img src="images/logo.jpg" width="100px" height="50px">
			<div class="pt-2">
			    <a href="/">
					<button class="btn btn-outline-primary">Logout</button>
				</a>
			</div>
		</nav>
		 </section>
		<section class="view" style="height: 530px" id="view">
			<h1 class="text-center">Student Details..!</h1>
			<table class="table table-hover" style="font-size: small">
				<thead>
					<tr>
						<th>ID</th>
						<th>Student Name</th>
						<th>Student Email</th>
						<th>Age</th>
						<th>Collage Name</th>
						<th>Course Name</th>
						<th>Bath No</th>
						<th>Mode</th>
						<th>Fess Recived</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					 
						<tr>
							<td>${stu.studentId}</td>
							<td>${stu.studentFullname}</td>
							<td>${stu.studentEmail}</td>
							<td>${stu.studentAge}</td>
							<td>${stu.studentCollegeName}</td>
							<td>${stu.studentCourse}</td>
							<td>${stu.batchNo}</td>
							<td>${stu.batchMode}</td>
							<td>${stu.feespaid}</td>
							<td>						
								<div class="btn-group btn-group-sm" role="group"
									aria-label="...">
									<button class="btn btn-outline-success">Pay- Fees</button>
									<button class="btn btn-outline-primary">Shift- Batch</button>
									<button class="btn btn-outline-danger">Remove</button>
								</div>
							</td>
						</tr>
					 
				</tbody>
			</table>
		</section>
	</div>

</body>
</html>