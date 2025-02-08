<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="Registration_header.html" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body{

            background-color: #757070;
            display: flex;
            flex-direction: column;
            align-items: center;
            
        }
        #user_signup{
			
            position: relative;
            width:380px;
            height: 450px;
            background-color: #1c1c1c;
            border-radius: 8px;
            overflow: hidden;
            margin-top: 2em;
            padding: 1em;
        }
        td{
        	padding: 1em;
        }
      #user_signup::before{
            content: "";
            position: absolute;
            width:400px;
            height: 450px;
            top:-50%;
            left:-50%;
            background:linear-gradient(0deg,#45f3ff,#45f3ff,#45f3ff);
            animation:animate 7s linear infinite;
            transform-origin: bottom right;

        }
  
        button{
        	background-color:black;
        	border:white;
        	width:150px;
        	margin-top:2em;
        	color:white;
        	
        }
        
        select{
        	background-color:#1c1c1c;
        	color:white;
        	width:170px;
        }

   

        @keyframes animate {
            0%{
                transform: rotate(0deg);
            }
            100%{
                transform: rotate(360deg);
            }
        }

         #form{
            position: absolute;
            inset:3px;
            background-color: #28292d;
            z-index:10;
            overflow-y: scroll;
          
        } 
        textarea{
        	background-color:#28292d;
        }
    </style>
</head>
<body>
	<h3 style='text-align:center;color:white;'>Create Account</h3>
    <div id="user_signup">
    
        <div id="form">
        
            <form action="signup" method="post">
                <table>
                    <tr>
                        <td><label for="">Enter First name</label></td>
                        <td><input type="text" placeholder="Enter firstname" name="userfname"></td>
                    </tr>
                    <tr>
                        <td><label for="">Enter Last name</label></td>
                        <td><input type="text" placeholder="Enter lastname" name="userlname"></td>
                    </tr>
                    <tr>
                        <td><label for="">Enter Email</label></td>
                        <td><input type="email" placeholder="Enter email" name="useremail"></td>
                    </tr>
                    <tr>
                        <td><label for="">Enter Password</label></td>
                        <td><input type="password" placeholder="Enter password" name="userpassword"></td>
                    </tr>
                          <tr>
                        <td><label for="">Enter Gender</label></td>
                        <td><select name="gender">
                        	<option value="male">Male
                        	<option value="female">Female
                        </select></td>
                    </tr>
                      <tr>
                        <td><label for="">Enter Address</label></td>
                        <td><textarea name="address" rows="1" placeholder="Enter Address"></textarea></td>
                    </tr>
                 
                          <tr>
                        <td><label for="">Enter city</label></td>
                        <td><input type="text" placeholder="Enter City" name="city"></td>
                    </tr>
                          <tr>
                        <td><label for="">Enter state</label></td>
                        <td><input type="text" placeholder="Enter state" name="state"></td>
                    </tr>
                  
                </table>
                <center><button>signup</button></center>
            </form>
        </div>
    </div>
    
</body>
</html>