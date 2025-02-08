

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * Servlet implementation class signup
 */
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String fname = request.getParameter("userfname");
		String lname = request.getParameter("userlname");
		String email = request.getParameter("useremail");
		String password = request.getParameter("userpassword");
		String state = request.getParameter("state");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		PrintWriter pw = response.getWriter();
		int temp = 1;
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root", "Ayush#2004");
			 PreparedStatement ps2 = conn.prepareStatement("select email,password from signup where email='"+email+"';");
			 ResultSet rs2 = ps2.executeQuery();
			 while(rs2.next())
			 {
				 String cemail = rs2.getString("email");
				 if(cemail.equals(email))
				 {
					 System.out.print("User Already exsist this email");
					
					 temp = 0;
					 RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
					 pw.print("<p>User Already exist this email "+email+"</p>");
					 rd.include(request, response);
					 
					 
				 }
			 }
	
			 if(temp == 1)
			 {
			 String id = "insert into signup(firstname, lastname, email,password, gender, address, city, state) values(?,?,?,?,?,?,?,?);";
			 PreparedStatement ps = conn.prepareStatement(id);
			 ps.setString(1, fname);
			 ps.setString(2, lname);
			 ps.setString(3, email);
			
			 ps.setString(4, password);
			 ps.setString(5, gender);
			 ps.setString(6, address);
			 ps.setString(7, city);
			 ps.setString(8, state);
			 ps.executeUpdate();
			
			 RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			 pw.print("<p>Congratulations !!! Your Account Has Been created succesfully...");
			 rd.include(request, response);
			
			
			
			 }
		}
		catch (Exception e) {
			
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			pw.print("<p>"+e.getLocalizedMessage()+"</p>");
			rd.include(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
