package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import interfaceentity.InterfaceClasse;
import interfaceentity.InterfaceClubSuivi;
import interfaceentity.InterfaceClubs;
import interfaceentity.InterfaceCours;
import interfaceentity.InterfaceCoursSuivi;
import interfaceentity.InterfaceEnseignant;
import interfaceentity.InterfaceEnseignantSuivis;
import interfaceentity.InterfaceEtudiant;
import interfaceentity.InterfaceFiliere;
import interfaceentity.InterfaceResource;
import metier.Classe;
import metier.Clubs;
import metier.Cours;
import metier.CoursSuivis;
import metier.Enseignant;
import metier.EnseignantSuivis;
import metier.Etudiant;
import metier.Filiere;
import metier.Resource;
import session.ClasseDAO;
import session.ClubSuiviDAO;
import session.ClubsDAO;
import session.CoursDAO;
import session.CoursSuiviDAO;
import session.EenseignatSuiviDAO;
import session.EnseignantDAO;
import session.EtudiantDAO;
import session.FiliereDAO;
import session.ResourceDAO;

/**
 * Servlet implementation class GetInfoEtudiant
 */
@WebServlet("/GetInfoensegiant")
public class GetInfoensegiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public InterfaceEnseignant enseignantdao;
	public InterfaceCours coursdao;
	public InterfaceEnseignantSuivis etudiantsuiviDAO;
	public InterfaceResource resourcedao;
	public InterfaceClubs clubsDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetInfoensegiant() {
		super();
		clubsDAO = new ClubsDAO();
		enseignantdao = new EnseignantDAO();
		coursdao = new CoursDAO();
		resourcedao = new ResourceDAO();
		etudiantsuiviDAO = new EenseignatSuiviDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// spring
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

		} else {
			System.out.println(session.getAttribute("enseingniantin"));
			int idetudiant;
			if (session.getAttribute("enseingniantin") != null)
				idetudiant = (int) session.getAttribute("enseingniantin");
			else {
				System.out.println(request.getParameter("ide"));
				idetudiant = Integer.parseInt((String) request.getParameter("ide"));
			}

			Enseignant enseignant = enseignantdao.getEnseignantById(idetudiant);
			List<Clubs> clubs = clubsDAO.getClubByEnseignant(enseignant.getIduser());
			Resource emplois = resourcedao.getResourceByIdType(enseignant.getIdemplois(), "emplois");
			// Et la date de publi.cation aussi
			List<Cours> courses = coursdao.getCoursByEnseignant(enseignant.getIduser());
			List<Etudiant> etudiants = etudiantsuiviDAO.getEtudiantByEnseignant(enseignant.getIdenseignant());
			System.out.println("cjvmw" + etudiants.size());
			request.setAttribute("enseignant", enseignant);
			request.setAttribute("emplois", emplois);
			request.setAttribute("courses", courses);
			request.setAttribute("clubs", clubs);
			request.setAttribute("etudiants", etudiants);

			/* On appelle la JSP pour affichage du formulaire */
			getServletContext().getRequestDispatcher("/enseingnantprofile.jsp").forward(request, response);
		}
	}

}
