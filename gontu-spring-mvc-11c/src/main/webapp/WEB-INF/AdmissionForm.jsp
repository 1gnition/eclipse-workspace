<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admission Form</title>
</head>
<body>
	<h1>${title}</h1>

	<h3>STUDENT ADMISSION FORM</h3>
	
	<form action="submitAdmissionForm.html" method="post">
		<p>
			Student Name: <input type="text" name="studentName" />
		</p>
		<p>
			Student's Hobby: <input type="text" name="studentHobby" />
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
</body>
</html>