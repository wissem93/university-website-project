package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.User;
import session.EnseignantDAO;
import session.EntrepriseDAO;
import session.EtudiantDAO;

/**
 * Servlet implementation class RegisterEtudiantServlet
 */
@WebServlet("/LoginEtudiantServlet")
public class LoginEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EtudiantDAO etudiantDAO;
	EnseignantDAO enseignantDAO;
	EntrepriseDAO entrepriseDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginEtudiantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		etudiantDAO = new EtudiantDAO();
		enseignantDAO = new EnseignantDAO();
		entrepriseDAO = new EntrepriseDAO();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getServletContext().getRequestDispatcher("/index.html").forward(request,
		// response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		User e = entrepriseDAO.LoginEnseignant(login, pwd);
		if (e == null) {
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		String type = request.getParameter("thelist");
		if (type.equals("Etudiant")) {
			if (etudiantDAO.getEtudiantById(e.getIduser()) != null) {
				System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
				   HttpSession session=request.getSession();  
			        session.setAttribute("etudiantin",e.getIduser());  
			        session.setAttribute("login",true);
				getServletContext().getRequestDispatcher("/indexin.jsp").forward(request, response);

				// getServletContext().getRequestDispatcher("/infoetudiant?idetud="
				// + e.getIduser()).forward(request,
				// response);
			} else
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

		} else if (type.equals("Enseingnant")) {
			if (enseignantDAO.getEnseignantById(e.getIduser()) != null)
			{		   HttpSession session=request.getSession();  
	        session.setAttribute("enseingniantin",e.getIduser());  
	        session.setAttribute("login",true);
				getServletContext().getRequestDispatcher("/indexin.jsp").forward(request,
						response);
			}else
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} else if (type.equals("Administrateur")) {

		} else if (type.equals("Entreprise")) {
			e = entrepriseDAO.LoginEnseignant(login, pwd);

		}

	}

}
