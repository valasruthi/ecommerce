<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
    
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<head>
<style>
body{
margin:0;
padding:0;
/* background:url(fashi.jpg); */
font-family:sans-serif;
}
.loginbox{
width:320px;
height:420px;
background:#000;
color:#fff;
top:50%;
left:50%;
position:absolute;
transform:translate(-50%,-50%);
box-sizing:border-box;
padding:70px 30px;
}
.avatar{
width:100px;
height:100px;
border-radius:50%;
position:absolute;
top:-50px;
left:calc(50% - 50px);
}
h1{
margin:0;
padding:0 0 20px;
text-align:center;
font-size:22px;
}
.loginbox p{
margin:0;
padding:0;
font-weight:bold;
}
.loginbox input{
width:100%;
margin-bottom:20px;
}
.loginbox input[type="text"], input[type="password"]
{
border:none;
border-bottom:1px solid #fff;
background:transparent;
outline:none;
height:40px;
color:#fff;
font-size:16px;
}
.loginbox input[type="submit"]
{
border:none;
outline:none;
height:40px;
background:#fb2525;
color:#fff;
font-size:18px;
border-radius:20px;
}

.loginbox input[type="submit"]:hover
{
cursor:pointer;
background:#ffc107;
color:#000;
}
.loginbox a{
text-decoration:none;
font-size:12px;
line-height:20px;
color:darkgrey;
}
.loginbox a:hover
{
color:#ffc107;

}
</style>
</head>
<body>
<jsp:include page="Header.jsp" />
<div class="loginbox">
<h1>Login here</h1>
  <form action="login" method="post">

<p>User MobileNo</p>
<input type="text" name="mobile" placeholder="enter mobile">
<p>password</p>
<input type="password" name="password" placeholder="Enter password">
<input type="submit" value="login">
<p>Don't have an account? </p>
 <a href="${contextPath}/reg"><button type="button">Sign Up</button></a>
</form>
</div>
</body>
</html>
<%@include file="Footer.jsp"%>