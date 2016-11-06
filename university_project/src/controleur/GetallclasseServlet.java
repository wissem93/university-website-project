package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaceentity.InterfaceClasse;
import metier.Classe;
import session.ClasseDAO;

/**
 * Servlet implementation class Getallclasse
 */
public class GetallclasseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InterfaceClasse classe;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetallclasseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		classe = new ClasseDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModelgetallClasse mod = new ModelgetallClasse();
		List<Classe> classes = classe.getAllClasse();
		mod.setClasses(classes);
		request.setAttribute("modele", mod);
		request.getRequestDispatcher("classeView.jsp").forward(request, response);

	}

}
