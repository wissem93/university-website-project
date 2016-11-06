package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Sujet;
import session.SujetDAO;

/**
 * Servlet implementation class AddSujet
 */
@WebServlet("/AddSujet")
public class AddSujet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSujet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/addsujet.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Sujet s = new Sujet();
		s.setTitre(request.getParameter("titre"));
		s.setDescription(request.getParameter("description"));

		s.setCategorie(request.getParameter("categorie"));
		s.setIduser(2);
		SujetDAO sujetDAO=new SujetDAO();
		sujetDAO.setSujet(s);
		getServletContext().getRequestDispatcher("/addsujet.jsp").forward(request, response);


	}

}
