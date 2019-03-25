<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
 prefix="fn"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
 src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Out Door Game Sports</title>

</head>
<body>
<%@include file="Header.jsp" %>
 <c:set var="images" value="${contextPath}/resources/carouselPics" />
 <c:set var="image" value="${contextPath}/resources" />
 <div class="container">
 <center>
   <c:if test="${cart.cart_quantity} == 0">
    <h2>Your Cart is Empty</h2>
    <a
      href="${contextPath}/products">
       <button type="button" class="btn btn-primary">Continue
        Shopping</button>
     </a>
    </c:if>
    </center>
  
  <div class="table-responsive">
   <table border="2" align="center" class="table table-inverse"
    style="width: 70%">
    
    <tr>
     <td>Product</td>
     <td>Price of Product</td>
     <td>Quantity</td>
     <td>Total Price</td>
     <td></td>
    </tr>
    
    
    <c:forEach items="${cartItems}" var="cartItem">
     <tr>
      <form action="${contextPath}/customer/editCartItems/${cartItem.caid}">
       <td>${cartItem.pdtl.pname}</td>
       <td>${cartItem.pdtl.pprice}</td>
       <td><input type="number" class="form-control"
        name="quantity" value="${cartItem.caquantity}"></td>
       <td>${cartItem.caprice}</td>

       <td>
        <button type="submit" class="btn btn-primary">Edit</button> <%-- <a href="${contextPath}/customer/editCartItems/${cartItem.caid}/cartItem"><button
        type="button" class="btn btn-primary">Edit</button></a> --%>
      </form>
      <a
       href="${contextPath}/customer/deleteCartItems/${cartItem.caid}/cartItem"><button
        type="button" class="btn btn-danger">Remove</button></a>
      </td>
    </c:forEach>
    </tr>
    <tr>
     <td colspan="3">Total Price of Cart</td>
     <td>${cart.cart_total}</td>
     <td></td>
    </tr>

    <tr>
     <td colspan="3" style="text-align: center"><a
      href="${contextPath}/products">
       <button type="button" class="btn btn-primary">Continue
        Shopping</button>
     </a></td>
     <td colspan="2" style="text-align: center"><a
      href="${contextPath}/customer/checkout">
       <button type="submit" class="btn btn-primary">Check Out</button>
     </a></td>
    </tr>
   </table>
   
  </div>
  
 </div>
</body>
</html>