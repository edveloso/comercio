<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   
	<jsp:include page="pages/templates/header.jsp"></jsp:include>

	<div class="container">
		<div class="row justify-content-center">
		   <div class="col-8">
		       <h4 class="mt-4 texto-cinza">
		       		Cadastro
		       </h4>
		       
		       <form action="<c:url value='/UserSrv?action=new' />"  
		          method="post"  
		        >
		          <div class="form-group">
						<input
						   type="text"
						   name="login"
						   id="login"
						   placeholder="endereço de email ou nome de usuário"
						   class="form-control"
						>
		          </div>
		          
		          <div class="form-group">
						<input
						   type="password"
						   name="senha"
						   id="senha"
						   placeholder="senha"
						   class="form-control"
						>
		          </div>	
		          
		          <button 
		            type="submit"
		            class="btn btn-success"
		           >Cadastrar</button>	        
		          
		            
		       
		       </form>
		       
		       
		   </div>
		</div>
		
		
		
		
	</div>


   

</body>
</html>