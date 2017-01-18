package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/shop")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");

		// nullチェック
		if (action == null) {
			action = "top";
		}

		if (action.equals("top")) {
			TopAction a = new TopAction();
			boolean result = a.execute(request, response);
			if (result) {
				RequestDispatcher rd = request.getRequestDispatcher("/top.jsp");
				rd.forward(request, response);
			} else {
			}

		} else if (action.equals("showAll")) {
			ShowAllAction a = new ShowAllAction();
			boolean result = a.execute(request, response);
			if (result) {
				RequestDispatcher rd = request.getRequestDispatcher("/showItem.jsp");
				rd.forward(request, response);
			} else {
			}

		} else if (action.equals("")) {
		}
	}
}
