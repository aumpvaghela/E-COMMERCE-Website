
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.tomcat.jakartaee.commons.lang3.ArrayUtils"%>
<%@page import="com.example.ecommerce_model.ecommerce_model"%>
<%@page import="java.util.List"%>
<%@page import="com.example.ecommercedao.ecommerce_dao"%>
<%@include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
	background-color:rgb(55,77,88);
}
	#show_products{
		display:flex;
		align-items: center;
		justify-content: center;
			
	
	}
	#my_products{
		background-color:rgb(61,70,80);
		box-shadow: 10px 10px 10px rgb(55,61,71);
		height:250px;
		width:300px;
		text-align:center;
		padding: 1em;
		margin-top: 2em;
			
	}
	#myimage{
		opacity:1;
		background-color:transparent;

	}
	@font-face  {
		font-family:myfont;
	src:url(./Merriweather-Black.ttf);
	}
		#myimage{
		transition:2s;
	}
	#myimage:hover {
		transform:scale(1.2);
		transition:2s ease;
}
	
</style>
</head>
<body>

		<%
		ecommerce_dao edao = new ecommerce_dao();
		List<ecommerce_model> list = new ArrayList();
		list = edao.display_products();
		if(!list.isEmpty()){
	%>
	<h1 style='text-align:center;color:white;'>Our Best Products</h1>
	<div id="show_products">
	
		<%
			for(ecommerce_model e : list)
			{
		%>
			
				<div style='margin-left:2em;' id="my_products">
				<a   style='text-decoration:none;color:white;' href="discription_img_show.jsp?id=<%=e.getP_id()  %>"><img id="myimage" style='height:150px; width:150px;' src="./All_images/<%=e.getProductimage() %>?"></a>
					
					<p style='font-family: myfont'>Price <%=e.getProduct_price() %></p>
					
				</div>
			
		<%
			}
		%>
		</div>
	
	<%
		}
	%>

</body>
</html>