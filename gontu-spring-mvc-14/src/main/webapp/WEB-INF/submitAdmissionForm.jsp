<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submit Admission Form</title>
</head>
<body>
	<h1>${title}</h1>

	<h3>Congratulations, your form has been processed</h3>
	
	<form:errors path="student.*" />

	<h4>Your details are:</h4>
	<table>
		<tr>
			<td>Name</td>
			<td>${student.studentName}</td>
		</tr>
		<tr>
			<td>Hobby</td>
			<td>${student.studentHobby}</td>
		</tr>
		<tr>
			<td>Mobile</td>
			<td>${student.studentMobile}</td>
		</tr>
		<tr>
			<td>Birth Date</td>
			<td>${student.dob}</td>
		</tr>
		<tr>
			<td>City</td>
			<td>${student.address.city}</td>
		</tr>
		<tr>
			<td>Street</td>
			<td>${student.address.street}</td>
		</tr>
		<tr>
			<td>Courses</td>
			<td>${student.courses}</td>
		</tr>
	</table>
</body>
</html>