<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<form:form id="regForm" modelAttribute="userregt"
		action="submitForm" method="post">
		<table align="center">
			<tr>
				<td><form:label path="FirstName">FirstName</form:label></td>
				<td><form:input path="FirstName" name="firstname"
						id="firstname" /></td>
			</tr><br><br>
			<tr>
				<td><form:label path="LastName">LastName</form:label></td>
				<td><form:input path="LastName" name="lastname" id="lastname" />
				</td>
			</tr><br><br>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr><br><br>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" name="address" id="address" />
				</td>
			</tr><br><br>
			<tr>
				<td><form:label path="mobile">Mobile</form:label></td>
				<td><form:input path="mobile" name="mobile" id="mobile" /></td>
			</tr><br><br>
			<tr>
				<td></td>
				<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
			<tr>
				<td><form:label path="confirmPassword">ConfirmPassword</form:label>
				</td>
				<td><form:password path="confirmPassword"
						name="confirmPassword" id="confirmPpassword" /></td>
			</tr>
				<td><form:button id="submit" name="submit">Register</form:button>
				</td>
			</tr>
			<tr></tr>
		</table>
	</form:form>
</body>
</html>