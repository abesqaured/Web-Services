package HW2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuGuest
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String orders;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		orders = "";
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>"
									+ "<HTML>"
									+ "<HEAD>"
									+ "<TITLE>Welcome To Fake Food</TITLE>"
									+ "</HEAD>"
									+ "<h1>Welcome To FakeFoods </h1>"
									+ "<form name ='Menu' method='post' action='Menu'>"
									+ "<p><input type='checkbox' name='nachos'>Nachos! $3</button></p>"
									+ "<p><input type='checkbox' name='deluxe'>Deluxe Nachos! $6</button></p>" 
									+ "<p><input type='checkbox' name='tacos' >Tacos!  $5</button></p>"
									+ "<p><input type='checkbox' name='mac' >Mac and Cheese $15</button></p>"
									+ "<p><input type='checkbox' name='poppers'> Jalapeno Poppers! $5</button></p>"
									+ "<p><input type='submit' value='order'/>"
									+ "</form>"									
									+ "<p> Your Order: You Have No Orders!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			if(request.getParameter("nachos") != null){
				orders = orders + "Nachos!......................$3.00<br/>";
			}
			
			if(request.getParameter("deluxe") != null){
				orders = orders + "Deluxe Nachos!...............$6.00<br/>";
			}
			
			if(request.getParameter("tacos") != null){
				orders = orders + "Tacos!.......................$5.00<br/>";
			}
			if(request.getParameter("mac") != null){
				orders = orders + "Mac and Cheese Pizza!........$15.00<br/>";
			}
			
			if(request.getParameter("poppers") != null){
				orders = orders + "Jalapeno Poppoers!...........$5.00<br/>";
			}
		
		
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>"
									+ "<HTML>"
									+ "<HEAD>"
									+ "<TITLE>Welcome To Fake Food</TITLE>"
									+ "</HEAD>"
									+ "<h1>Welcome To FakeFoods </h1>"
									+ "<form name ='MenuGuest' method='post' action='MenuGuest'>"
									+ "<p><input type='checkbox' name='nachos'>Nachos! $3</button></p>"
									+ "<p><input type='checkbox' name='deluxe'>Deluxe Nachos! $6</button></p>" 
									+ "<p><input type='checkbox' name='tacos' >Tacos!  $5</button></p>"
									+ "<p><input type='checkbox' name='mac' >Mac and Cheese $15</button></p>"
									+ "<p><input type='checkbox' name='poppers'> Jalapeno Poppers! $5</button></p>"
									+ "<p><input type='submit' value='order'/>"
									+ "</form>"										
									+ "<p> Your Order:"
									+ orders);
		
	}

}
