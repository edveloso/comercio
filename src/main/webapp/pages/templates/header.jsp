<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/main.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-light bg-dark">
	   <span class="navbar-header " >
	      <h1>
	        <a class="nav-header" 
	        	href="<c:url value='/pages/home.jsp' /> ">
	        	netshop 
	        </a>
	      </h1> 
	   </span>
	   
	   <div class="navbar-text">
	       <c:if test="${not empty sessionScope.user}">
	       		<span class="nav-header mr-4"
	       		> Seja bem vindo ${sessionScope.user}</span>
	       		<a
	       		 href="<c:url value='/LogoutSrv' />" >Logout</a>
	       </c:if>
	   
	   </div>
	   
	</nav>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
			
		
</body>
</html>


