package HW2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MeanUserName
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private int accessCount;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>"
									+ "<HTML>"
									+ "<HEAD>"
									+ "<TITLE>Welcome To Fake Food</TITLE>"
									+ "</HEAD>"
									+ "<H2 ALIGN='CENTER'>Login To Fake Food</H2>"
									+ "<FORM ACTION='Login' method='post' >"
									+ "<CENTER>"
									+ "User Name:"
									+ "<INPUT TYPE='TEXT' NAME='username'>"
									+ "Password:"
									+ "<INPUT TYPE='TEXT' NAME='password'>"
									+ "<INPUT TYPE='SUBMIT' NAME='Login'>" 
									+ "</CENTER>"
									+ "</FORM>"
									+ "</BODY>"
									+ "</HTML>");
	}		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		username = request.getParameter("username");
		password = request.getParameter("password");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession(); 
		if(session.isNew() == true){
			accessCount = 0;
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		session.setAttribute("accessCount", accessCount);
		response.getWriter().write("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>"
				+ "<HTML>"
				+ "<HEAD>"
				+ "<TITLE>Welcome To Fake Food</TITLE>"
				+ "</HEAD>"
				+ "<H2 ALIGN='CENTER'>Welcome To Your New Account, " + username + "</H2>"
				+ "<P>This has been accessed: " + accessCount 
				+ "</BODY>"
				+ "</HTML>");
		}else if(session.isNew() == false){
			accessCount = (int) session.getAttribute("accessCount");
			accessCount++;
			response.getWriter().write("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>"
					+ "<HTML>"
					+ "<HEAD>"
					+ "<TITLE>Welcome To Fake Food</TITLE>"
					+ "</HEAD>"
					+ "<H2 ALIGN='CENTER'>Welcome Back, " + username + "</H2>"
					+ "<P>This has been accessed: " + accessCount 
					+ "</BODY>"
					+ "</HTML>");
			session.setAttribute("accessCount", accessCount);
		}else{
			this.doGet(request,response);
		}
	}



}
