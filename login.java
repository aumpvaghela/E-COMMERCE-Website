

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		String email = request.getParameter("useremail");
		String password = request.getParameter("userpassword");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root", "Ayush#2004");
			 String sd =  "select email,password from signup where email = (?)";
			 PreparedStatement ps = conn.prepareStatement(sd);
		
			 ps.setString(1, email);
		
			 ResultSet rs = ps.executeQuery();
			 int temp = 0;
			 while(rs.next())
			 {
				 String useremail = rs.getString("email");
				 String userpassword = rs.getString("password");
				 if(useremail.equals(email) && userpassword.equals(password))
				 {
					 response.sendRedirect("Home.jsp");
					 temp = 1;
					 HttpSession ht = request.getSession();
					 ht.setAttribute("email", useremail);
					
				 }
			 }
			
			if(temp == 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("login");
				rd.include(request, response);
				PrintWriter pw = response.getWriter();
				pw.println("<script>alert('Invalid Login  email and password');</script>");
			}
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
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
