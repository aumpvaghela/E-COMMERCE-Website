<%@page import="java.util.ArrayList"%>
<%@page import="com.example.ecommerce_model.ecommerce_model"%>
<%@page import="java.util.List"%>
<%@page import="com.example.ecommercedao.ecommerce_dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Admin_Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	body{
		background-color: #3c3939;
		
	}
	table{
		padding:1em;
		border:none;
		margin: auto;
		text-align:center;
	}
	td{
		padding:1em;
		color:white;
		font-family:cursive;
		
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
	<table>
		<tr>
			<td>Product name</td>
			<td>Product size</td>
			<td>Product price</td>
			<td>Product quntity</td>
			<td>Product gender</td>
			<td>Product color</td>
			<td>Product image</td>
		</tr>
		<%
			for(ecommerce_model e : list)
			{
		%>
		<tr>
			<td><%=e.getProduct_name() %></td>
			<td><%=e.getProduct_size() %></td>
			<td><%=e.getProduct_price() %></td>
			<td><%=e.getProduct_qty() %></td>
			<td><%=e.getProduct_gender() %></td>
			<td><%=e.getProduct_color() %></td>
			<td><img style='height:150px;width:150px;' src="./All_images/<%=e.getProductimage()%>"></td>
		</tr>
		<%
			}
		%>
		<%
		}
	%>
	</table>
	
</body>
</html>