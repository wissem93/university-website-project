package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Resource;
import session.ResourceDAO;

/**
 * Servlet implementation class AddNote
 */
@WebServlet("/AddNote")
public class AddNote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/addnote.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Resource note = new Resource();
		note.setIdresource(1);
		note.setNom(request.getParameter("name"));
		note.setUrlRsource(request.getParameter("urlRsource"));
		note.setDescription(request.getParameter("description"));
		note.setType("note");
		ResourceDAO noteDAO=new ResourceDAO();
		noteDAO.setResource(note);
		getServletContext().getRequestDispatcher("/addnote.jsp").forward(request, response);

	}

}
