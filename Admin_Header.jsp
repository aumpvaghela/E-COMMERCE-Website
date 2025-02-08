<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

body{
	background-color:white;
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
		background-color:#191c24;
		padding: 1em;
		align-items:center;
		color:white;
		box-sizing:border-box;
		border-radius: 5px;
	}
	#links .a1{
		text-decoration:none;
		color:black;
		margin-left: 2em;
		font-family:fantasy;
		color:#6b6e85;
		transition:2s;
	}
	#links .a1:hover{
		color:red;
	}
	h3 #logout{
		display:none;
	}
	h3:hover #logout{
		display:block;
		color:red;
		
	}
	

</style>
</head>
<body>
	<div id="header_container">
		<div id="main_container">
			<div id="links">
			<h3>EGrow</h3>
			<h3 style='margin-left: 1em;'>welcome Ayush
			<div id="logout">
				
				<a style='text-decoration:none;color:white;' href="#">Logout</a>
				</div>
			</h3>
				
				<a class="a1" href="./Add_product.jsp">Add Products</a>
				<a class="a1"  href="./display_products.jsp">Show Products</a>
				
				
			</div>
		</div>
	</div>
</body>
</html>