<%@include file="Header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories</title>
</head>
<body>
	<form:form id="catForm" modelAttribute="categoryDetails"
		action="${contextPath}/admin/catprocess" method="post">

		<div class="table-responsive">

			<center>
				<h2>Category form</h2>
			</center>
			</br>

			<div class="container">

				<div class="row">

					<div class=col-sm-3></div>

					<div class="col-sm-6">

						<div class="form-group">

							<form:input path="ctid" type="hidden" />

							<label for="ctName">Category Name:</label>

							<form:input path="ctName" name="ctName" id="ctName"
								required="true" class="form-control" />

						</div>

						<div class="form-group">

							<label for="ctDescription">Category Description:</label>

							<form:input path="ctDescription" name="ctDescription" id="ctDescription"
								class="form-control" />

						</div>

						<button type="submit" class="btn btn-default">Add
							Category</button>

					</div>

				</div>

			</div>

		</div>
		<br>
		<br>
		<br>
		<div class="table-responsive">
			<table border="2" align="center" class="table table-inverse"
				style="width: 70%">
				<tr>
					<th>Category Name</th>
					<th>Category Description</th>
					<th>Edit Category</th>
					<th>Delete Category</th>
				</tr>
				<c:forEach items="${catlist}" var="cat">
					<tr>
						<td>${cat.ctName}</td>
						<td>${cat.ctDescription}</td>
						<td><a href="${contextPath}/admin/updateCat/${cat.ctid}"><button
									type="button" class="btn btn-primary">Edit</button></a></td>
						<td><a href="${contextPath}/admin/deleteCat/${cat.ctid}"><button
									type="button" class="btn btn-danger">Delete</button></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form:form>
</body>
</html>
<%@include file="Footer.jsp"%>