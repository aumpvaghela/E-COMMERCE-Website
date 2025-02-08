

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Addproduct
 */
@WebServlet("/Addproduct")
@MultipartConfig(maxFileSize = 16177216)
public class Addproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addproduct() {
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
		String prodname = request.getParameter("prodname");
		String prodsize = request.getParameter("prodsize");
		int prodprice = Integer.parseInt(request.getParameter("prodprice"));
		int prodqty = Integer.parseInt(request.getParameter("prodqty"));
		String prodcolor = request.getParameter("prodcolor");
		String prodgender = request.getParameter("prodgender");
		Part  part =  request.getPart("image");
		String imageFileName = part.getSubmittedFileName();
		System.out.print(imageFileName);
		String upload_path = "D:/My_Projects/Ecommerce/src/main/webapp/All_images/"+imageFileName;
		
		
			try {
				
				   FileOutputStream fos = new FileOutputStream(upload_path);
				   InputStream is = part.getInputStream();
				   byte[] data = new byte[is.available()];
				   
				   is.read(data);
				   fos.write(data);
				   fos.close();
				   
				   Class.forName("com.mysql.cj.jdbc.Driver");
				   Connection conn = DriverManager.getConnection(
			                "jdbc:mysql://localhost:3306/ecommerce",
			                "root", "Ayush#2004");
				   
						String id = "insert into products(productname, productsize, productprice, productqty, productgender, productcolor, productimage) values(?,?,?,?,?,?,?);";
				PreparedStatement ps = conn.prepareStatement(id);
				ps.setString(1, prodname);
				ps.setString(2, prodsize);
				ps.setInt(3, prodprice);
				ps.setInt(4, prodqty);
				ps.setString(5, prodgender);
				ps.setString(6,prodcolor);
				ps.setString(7,imageFileName);
				ps.executeUpdate();
				System.out.println("Data Added");
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
