<%@page import="com.example.ecommerce_model.ecommerce_model"%>
<%@page import="com.example.ecommercedao.ecommerce_dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	body{
	background-color:rgb(63,71,80);
	}
	#mydiv{
		display: flex;
	}
	#dis{
		margin-left: 7em;
	}
	input{
	
		background-color:rgb(63,71,80);
		border:none;
		outline:none;
		border:2px solid white;
		margin-left: 2em;
		color:white;
	}
	label{
		color:white;
		font-family:serif;
	}
	button{
		background-color: rgb(63,71,80);
		color:black;
		border:2px solid white;
		outline:none;
		padding:0.5em;
		margin-top:2em;
		color:white;
		border-radius:2em;
		width:100px;
		transition:2s;
	}
	button:hover {
	background-color:orange;
}
</style>
</head>
<body>
	<%
	
	
		ecommerce_model emodel = new ecommerce_model();
		ecommerce_dao edao = new ecommerce_dao();
		int id = Integer.parseInt(request.getParameter("id"));	
		
		emodel=edao.getImage(id);
		
	%>
	<div id="mydiv">
	
	
				<div id="img">
				<img style='height:300px;width:300px;' src="./All_images/<%= emodel.getProductimage()%>">
				</div>
				<div id="dis">
				
				
				<p style='width:400px;color:white;'>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Earum vero, nobis aliquam quidem culpa, explicabo optio fugiat officiis quisquam doloribus quis deserunt sit.</p>
		
				
				<form action="Addcart" method="post">
					<label>Quantity</label>
					<input hidden type='text' name="pid" value=<%=emodel.getP_id() %>>
					
					<input type="number" name="qty"  name="qty"><br>
					<button>Add cart</button>
					
				</form>
					
			
				</div>
		
	</div>
</body>
</html>