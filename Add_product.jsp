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
background-color:#191c24;
}
@font-face{

	font-family:Myfont;
	src:url(./Merriweather-Black.ttf);
}
	#product_container{
		display: flex;
		align-items: center;
		justify-content: center;
	}
	#form{
		padding:1em;
		

		width:500px;
		margin-top: 2em;
		
	}
	table{
		
		text-align:center;
	}
	td{
		padding:1em;
	}
	label{
		font-family: Myfont;
		color:white;
		
		
	}
	input{
		 background-color:rgba(0,0,0,0.1);
		
		
		 border:none;
		 outline:none;
		
		 
		
	}
</style>
</head>
<body>
	<div id="product_container">
	
		<div id="form">
			<form action="Addproduct"   method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td><label>Product name</label></td>
						<td><input  type="text" placeholder="Product name" name="prodname"></td>
					</tr>
					<tr>
						<td><label>Product size</label></td>
						<td><input type="text" placeholder="Product size" name="prodsize"></td>
					</tr>
				
					<tr>
						<td><label>Product color</label></td>
						<td><input type="text" placeholder="Product color" name="prodcolor"></td>
					</tr>
					<tr>
						<td><label>Product price</label></td>
						<td><input type="text" placeholder="Product price" name="prodprice"></td>
					</tr>
					<tr>
						<td><label>Product quntity</label></td>
						<td><input type="text" placeholder="Product quntity" name="prodqty"></td>
					</tr>
					
					<tr>
						<td><label>Product gender</label></td>
						<td><input type="radio" name="prodgender" value="male"><label>Male</label>
						<input type="radio" name="prodgender" value="female"><label>Female</label>
						
						</td>
					</tr>
					<tr>
						<td><label>Product Image</label></td>
						<td><input type="file" name="image"></td>
						
					</tr>
				</table>
				<center><button>ADD</button></center>
			</form>
		</div>
	</div>
</body>
</html>