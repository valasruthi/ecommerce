<%@include file="Header.jsp" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>User page</title>
<style>
.button {
    background-color:black;
    border: none;
    color: white;
    padding: 10px 24px;
    text-align: center;
    text-decoration: blink;
    display: inline-block;
    font-size: 14px;
    margin: 1px 1px;
    cursor: pointer;
      font-style: oblique;
}

</style>
</head>
<body>
	<div class="container-fluid padding">
		<div class="row text-left padding">
         <h4><b>&nbsp&nbsp PARTYWEAR ANARKALI KURTAS<b></h4><hr>
			<div class="col-xs-12 col-sm-6 col-md-4">
				<img src="${contextPath}/resources/Green.jpg" href="#"
					style="width: 300px; height: 300px">
					<h4>Green Georgette Embroidered Anarkali</h4>
					<a href="#" class="button">SHOW DETAILS</a>&nbsp&nbsp
					<a href="#" class="button">ADD TO CART</a>
						
			</div>
			
			<div class="col-xs-12 col-sm-6 col-md-4">
				<img src="${contextPath}/resources/greenred.jpg" href="#"
					style="width: 300px; height: 300px">
					<h4>Georgette Embroidered Straight Salwar Suit </h4>
				<a href="#" class="button">SHOW DETAILS</a>&nbsp&nbsp
					<a href="#" class="button">ADD TO CART</a>
			</div>
			
			<div class="col-xs-12 col-sm-6 col-md-4">
				<img src="${contextPath}/resources/Red anarkali.jpeg" href="#"
					style="width: 300px; height: 300px">
					<h4>Red Color Foil Work Desinger Dress</h4>
				<a href="#" class="button">SHOW DETAILS</a>&nbsp&nbsp
					<a href="#" class="button">ADD TO CART</a>
			</div>
			
		</div>
	</div>
	<hr>
	<div class="container-fluid padding">
		<div class="row text-left padding">
         <h4><b>&nbsp&nbsp CASUAL WEAR KURTAS<b></h4><hr>
			<div class="col-xs-12 col-sm-6 col-md-4">
				<img src="${contextPath}/resources/black.jpg" href="#"
					style="width: 300px; height: 300px">
					<h4>Abhishti Women Black Woven Kurta</h4>
					<a href="#" class="button">SHOW DETAILS</a>&nbsp&nbsp
					<a href="#" class="button">ADD TO CART</a>	
			</div>
			
			<div class="col-xs-12 col-sm-6 col-md-4">
				<img src="${contextPath}/resources/red.jpg" href="#"
					style="width: 300px; height: 300px">
					<h4>GERUA Women Red Solid A-Line Kurta </h4>
				<a href="#" class="button">SHOW DETAILS</a>&nbsp&nbsp
					<a href="#" class="button">ADD TO CART</a>
			</div>
			
			<div class="col-xs-12 col-sm-6 col-md-4">
				<img src="${contextPath}/resources/white.jpg" href="#"
					style="width: 300px; height: 300px">
					<h4>Varanga Off-White Gold Print Kurta</h4>
				<a href="#" class="button">SHOW DETAILS</a>&nbsp&nbsp
					<a href="#" class="button">ADD TO CART</a>
			</div>
			
		</div>
	</div>
</body>
</html>
<%@include file="Footer.jsp"%>