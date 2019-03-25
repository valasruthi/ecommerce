<%@include file="Header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="image" value="${contextPath}/resources" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>product</title>
</head>
<body>
	<form:form id="prodForm" modelAttribute="productDetails"
		action="${contextPath}/admin/productprocess"
		enctype="multipart/form-data" method="post">

		<div class="table-responsive">
			<center>
				<h2>Product form</h2>
			</center>
			</br>

			<div class="container">
				<div class="row">
					<div class=col-sm-3></div>
					<div class="col-sm-6">
						<div class="form-group">
							<form:input path="pid" type="hidden" />
							<label for="pname">Product Name:</label>
							<form:input path="pname" name="pname" id="pname" required="true"
								class="form-control" />
						</div>
						<div class="form-group">
							<label for="pdescription">Product Description:</label>
							<form:input path="pdescription" name="pdescription"
								id="pdescription" class="form-control" />
						</div>

						<div class="form-group">
							<label for="pprice">Product Price:</label>
							<form:input path="pprice" name="pprice" id="pprice"
								class="form-control" />
						</div>

						<div class="form-group">
							<label for="stock">Product Stock:</label>
							<form:input path="stock" name="stock" id="stock"
								class="form-control" />
						</div>
						<div class="form-group">
							<label for="category">Category:</label>
							<div class="dropdown">
								<form:select path="categorydetails.ctid" class="form-control"
									required="true">
									<form:option value="0" label="---Select Category---" />
									<form:options items="${catlist}" itemValue="ctid"
										itemLabel="ctName" />
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label for="pimage">Upload Image:</label>
							<form:input path="pimage" type="file" class="form-control"
								required="true" />

						</div>
						<button type="submit" class="btn btn-default">Add Product</button>
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
					<th>Product Image</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Product Price</th>
					<th>Product Stock</th>
					<th>Edit Product</th>
					<th>Delete Product</th>
				</tr>
				<c:forEach items="${productlist}" var="pro">
					<tr style="text-align: center">
						<td><img src="${image}/${pro.pid}.jpg"
							style="width: 100px; height: 100px;">
						<td><a href="${contextPath}/productDisplay/${pro.pid}">${pro.pname}
						</a></td>
						<td>${pro.pdescription}</td>
						<td>${pro.pprice}</td>
						<td>${pro.stock}</td>
						<td><a
							href="${contextPath}/admin/updateProductData/${pro.pid}"><button
									type="button" class="btn btn-primary">Edit</button></a></td>
						<td><a href="${contextPath}/admin/deletepro/${pro.pid}"><button
									type="button" class="btn btn-danger">Delete</button></a></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</form:form>
</body>
</html>
<%@include file="Footer.jsp"%>