

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
 * Servlet implementation class showproducts
 */
public class showproducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showproducts() {
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
		try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   Connection conn = DriverManager.getConnection(
		                "jdbc:mysql://localhost:3306/ecommerce",
		                "root", "Ayush#2004");
			   String sd = "select * from products";
			   PreparedStatement ps = conn.prepareStatement(sd);
			   ResultSet rs = ps.executeQuery();
			   PrintWriter pw = response.getWriter();
			   while(rs.next())
			   {
				   String img = rs.getString("productimage");
				   pw.println(img);
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
