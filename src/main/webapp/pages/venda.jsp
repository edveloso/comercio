<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="templates/header.jsp"></jsp:include>

	<c:if test="${empty sessionScope.user}">
		<jsp:forward page="../login.jsp"></jsp:forward>
	</c:if>


	<div class="container">

		<div class="row justify-content-center">
			<div class="col-10">

				<div class="row pt-4 ">

	
			<c:forEach  var="prod"  items="${lista_produtos}">
			
			
					<div class="card m-2 p-2" style="width: 18rem;">
						<img class="card-img-top" width="200px" alt="iphone"
							src="${pageContext.request.contextPath}/img/iphone.jpeg">
						<div class="card-body">
							<h5 class="card-title">${prod.nome}</h5>
							<p class="card-text">${prod.descricao}
							    - ${prod.preco}
							</p>
							
							<a href="#" class="btn btn-success">Visitar</a>
						</div>
					</div>
					
					
			</c:forEach>	
			
				

				</div>
			</div>
		</div>
	</div>

</body>
</html>