

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
 * Servlet implementation class Addcart
 */
public class Addcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addcart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    int subtotal = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		int pid = Integer.parseInt(request.getParameter("pid"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		PrintWriter pw = response.getWriter();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root", "Ayush#2004");
			String sd = "select * from products where pid = ?";
			PreparedStatement ps = conn.prepareStatement(sd);
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			int pid2 = 0;
			while(rs.next())
			{
				pid2 = rs.getInt("pid");
			}
			
			
			
			String sd1 = "select uid from signup where email = ?";
			PreparedStatement ps2 = conn.prepareStatement(sd1);
			
			
			HttpSession hsession = request.getSession();
			String email = (String) hsession.getAttribute("email");
			
			
			
			ps2.setString(1,email);
			ResultSet rs2 = ps2.executeQuery();
			
			
			int uid = 0;
			while(rs2.next())
			{
				uid = rs2.getInt("uid");
			}
			
			
		
			String id = "insert into addcart(product_id,user_id) values(?,?);";
			
			PreparedStatement ps3 = conn.prepareStatement(id);
			
			ps3.setInt(1, pid2);
			
			ps3.setInt(2, uid);
			
			ps3.executeUpdate();
			
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		pw.print("<input type='text' name='qty' value="+qty+">");
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
