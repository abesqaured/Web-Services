package HW2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RestItems
 */
@WebServlet("/items/*")
public class RestItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path;
	private String item;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		path = request.getPathInfo();
		if(path.endsWith("/items")){
			//displays all products
			
		}else if (!path.endsWith("/items")){
			//displays requested product
			
		}
		
	}


}
