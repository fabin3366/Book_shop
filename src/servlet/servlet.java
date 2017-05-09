package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.publication;
import util.randGeneration;
import util.search;
import util.search;

/**
 * Servlet implementation class servlet
 */
@WebServlet(urlPatterns = "/control", displayName = "servlet")
// @WebServlet("/parsebooks")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private search search;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String nextPage = "";
		// String xmlPath =
		// getServletConfig().getServletContext().getRealPath("/")+"dblp.xml";
		// System.out.println(xmlPath);
		String action = request.getParameter("action");

		// System.out.println("the action value is"+action);
		String path = getServletConfig().getServletContext().getRealPath("/");
		path = path + "dblp.xml";
		search search = new search();
		ArrayList<publication> results = new ArrayList<publication>();
		HttpSession session = request.getSession();
		

		if (action.equals("search")) {
			String searchType = request.getParameter("searchType");
			String searchContent = request.getParameter("searchContent");
			String[] keywords = searchContent.split(" ");

			// for (int i = 0; i < keywords.length; ++i){
			// System.out.println(keywords[i]);
			// }

			// publication tmp = new publication();
			// tmp.setAuthor("Thomas");
			// tmp.setTitle("Sleeping Baby");
			// tmp.setYear("1982");
			// results.add(tmp);

			results = search.matchKeyWords(keywords, searchType);
			if (results.size() == 0) {
				nextPage = "error.jsp";
			} else {
				session.setAttribute("results", results);
				nextPage = "result.jsp";
			}
		} else if (action.equals("moredetails")) {
			String itemId = request.getParameter("itemid");

			publication publChosen = search.findSingleItem(itemId);
			// System.out.println("the chosen item is: " + publChosen);
			request.setAttribute("publChosen", publChosen);
			nextPage = "resultInfo.jsp";
		} else if (action.equals("addtocart")) {
			String itemId = request.getParameter("itemid");
			ArrayList<publication> cart = (ArrayList<publication>)session.getAttribute("cart");
			if (cart == null){
				cart = new ArrayList<publication>();
			}
			publication pub = search.findSingleItem(itemId);
			if (!search.isDuplicated(cart, itemId)){
				//System.out.println("not duplicated");
				cart.add(pub);
			}
			session.setAttribute("cart", cart);
			nextPage = "cart.jsp";
		}else if (action.equals("removefromcart")){
			String[] itemId = request.getParameterValues("cartoperation");
			ArrayList<publication> cart = (ArrayList<publication>)session.getAttribute("cart");
			if (cart == null){
				cart = new ArrayList<publication>();
			}
			ArrayList<publication> cart1 = new ArrayList<publication>();
			cart1 = search.removeFromCart(cart, itemId);
			session.setAttribute("cart", cart1);
			nextPage = "cart.jsp";
		}else if (action.equals("addvancedsearch")){
			String publType = request.getParameter("publType");
			//System.out.println(publType + "type is not null");
			String title = request.getParameter("advtitle");
			//System.out.println(title+ "title is not null");
			//String[] titleKeywords = title.split(" ");
			String author = request.getParameter("advauthor");
			//System.out.println(author+ "author is not null");
			//String[] authorKeywords = author.split(" ");
			String year = request.getParameter("advyear");
			//System.out.println(year+ "year is not null");
			//String[] yearKeywords = year.split(" ");
			String isbn = request.getParameter("advisbn");
			//System.out.println(isbn+ "isbn is not null");
			ArrayList<publication> advResults = new ArrayList<publication>();
			advResults = search.advancedSearch(title, year, author, publType, isbn);			
			if (advResults.size() == 0) {
				nextPage = "error.jsp";
			} else {
				session.setAttribute("results", advResults);
				nextPage = "result.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/" + nextPage);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession();
		//ArrayList<publication> cart = new ArrayList<publication>();		
		//session.setAttribute("cart", cart);
		//session.setAttribute(arg0, arg1);
		doPost(request, response);
	}
	

}
