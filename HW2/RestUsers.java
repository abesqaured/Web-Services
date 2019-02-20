package HW2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * Servlet implementation class restusers
 */
@WebFilter("/users/*")
public class RestUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path;
	private Account db = new Account();
	private Account notFound;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestUsers() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		path = request.getPathInfo();
		if(path.endsWith("/users")){
			//displays all
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(db.getUsers());
			response.setContentType("application/json");
			response.getWriter().append(json);
			
		}else if (!path.endsWith("/users")){
			//displays requested user
			String split[] = path.split("/");
			String u = split[2];
			String p = split[3];
			Account asked = new Account(u,p);
			if(!db.checkDB(asked).equals(notFound)){
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(db.checkDB(asked));
			response.setContentType("application/json");
			response.getWriter().append(json);
			}else{
				response.setContentType("application/json");
				response.setStatus(404);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		path = request.getPathInfo();
		if (path.contains("/users/add")){
			String split[] = path.split("/");
			String u = split[2];
			String p = split[3];
			db = new Account(u, p);
			//displays all
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(db.getUsers());
			response.setContentType("application/json");
			response.getWriter().append(json);
			

		}
	}

}
