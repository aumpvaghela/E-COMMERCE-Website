<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

body{
	
	padding:0px;
	margin:0px;
}
	#header_container{
		width:100%;
	}
	#main_container{
		width:100%;
	}
	#links::selection{
		background-color:black;
		color:white;
	}
	#links{
		width:100%;
		display:flex;
		background-color:rgba(0,0,0,0.3);
		padding: 1em;
		align-items:center;
		box-sizing:border-box;
		border-radius: 5px;
		color:white;
	}
	#links a{
		text-decoration:none;
		color:white;
		margin-left: 2em;
		font-family:fantasy;
		transition:3s;
	}
	#links a:hover{
		color:orange;
	}

</style>
</head>
<body>

	<div id="header_container">
	
		<div id="main_container">
	
			<div id="links">
				
			<img style='border-radius: 100%;' height="100px" width="100px"  src="./Personal_image/egrow.png">
			<%
				HttpSession hsession = request.getSession();
				out.print("<p style='margin-left:2em;' >Welcome "+hsession.getAttribute("email")+"</p>");
			%>
				<a href="./Home.jsp">Home</a>
				<a  href="./shop.jsp">Shop</a>
				<a href="#">Contact</a>
				<a  href="#">About</a>
				<a href="#">cart</a>
				
			</div>
		</div>
	</div>
</body>
</html>