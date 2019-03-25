<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Products</title>
</head>
<body>
<%@include file="Header.jsp"%>
 <c:set var="image" value="${contextPath}/resources" />
<div class="container-fluid">

  <div class="row">
   <div class="col-md-2">

    <h2 style="text-align: center">Categories</h2>
    </br>
    <ul class="list-group">
     <c:forEach items="${catlist}" var="cat">

      <li class="list-group-item"><a
       href="${contextPath}/CategorizedProducts/${cat.ctid}">${cat.ctName}</a></li>
     </c:forEach>

    </ul>

   </div>
   <div class="col-md-10">
    <h2 style="text-align: center">Products List</h2>
    </br>
    <c:forEach items="${productlist}" var="products">
     <div class="col-sm-3" style="text-align: center">

      <a href="${contextPath}/productDisplay/${products.pid}"><img
       src="${image}/${products.pid}.jpg" class="img-thumbnail">
       <h3>${products.pname}</h3> </a>
      <h3>${products.pprice}</h3>

     </div>
    </c:forEach>
   </div>

  </div>
 </div>

</body>
</html>