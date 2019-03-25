<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.navbar {
	background-color:purple;
	border: none;
	color: white;
	padding: 12px 28px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 15px;
	margin: 2px 2px;
	width: 100%;
}
</style>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#" style="color:white">WebSiteName</a>
			</div>
			<ul class="nav navbar-nav">

				<li><a href="${contextPath}" style="color:white">Home</a></li>
				<security:authorize access="hasAuthority('ROLE_ADMIN')">
					<li><a href="${contextPath}/admin/product" style="color:white">Product </a></li>
					<li><a href="${contextPath}/admin/category" style="color:white">Category</a></li>
				</security:authorize>
				<%-- <li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#" style="color:white">Shop by Category<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Ethic Wear Kurtas</a></li><hr>
						<li><a href="#">Casual Wear</a></li>
					</ul></li>
			<security:authorize access="!hasAuthority('ROLE_ADMIN')">
				<li><a href="#" style="color:white">Todays Deals</a></li>
				<li><a href=""${contextPath}/products"" style="color:white">Products</a></li>
			</ul> --%>
				<security:authorize access="!hasAuthority('ROLE_ADMIN')">
					<li><a href="${contextPath}/products" style="color:white">Products</a></li>
					<li><a href="${contextPath}/category" class="dropdown-toggle"
						data-toggle="dropdown" style="color:white">Shop by Category<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<c:forEach items="${catlist}" var="cat">
								<li><a
									href="${contextPath}/CategorizedProducts/${cat.ctid}">${cat.ctName}</a></li>
							</c:forEach>
						</ul></li>
				</security:authorize>
				<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li><a href="${contextPath}/reg" style="color:white"><span
							class="glyphicon glyphicon-user" style="color:white"></span> Sign Up</a></li>
					<li><a href="${contextPath}/login" style="color:white"><span class="glyphicon glyphicon-log-in" style="color:white"></span> Login</a></li>
					</security:authorize>
					<security:authorize access="hasAuthority('ROLE_USER')">
					<li><a href="${contextPath}/customer/myCart" style="color:white"><span class="glyphicon glyphicon-shopping-cart" style="color:white";>${cart.cart_quantity}</span>Cart</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li id="logout"><a href="${contextPath}/perform_logout" style="color:white"><span
							class="glyphicon glyphicon-user" style="color:white" ></span>Logout</a></li>
				</security:authorize>
			</ul>
			<form class="navbar-form navbar-left" action="/action_page.php">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search"
						name="search">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
	</nav>
	