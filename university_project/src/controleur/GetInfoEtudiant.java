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
import metier.Etudiant;
import metier.Filiere;
import metier.Resource;
import session.ClasseDAO;
import session.ClubSuiviDAO;
import session.ClubsDAO;
import session.CoursSuiviDAO;
import session.EenseignatSuiviDAO;
import session.EtudiantDAO;
import session.FiliereDAO;
import session.ResourceDAO;

/**
 * Servlet implementation class GetInfoEtudiant
 */
@WebServlet("/GetInfoEtudiant")
public class GetInfoEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public InterfaceEtudiant etudiantdao;
	public InterfaceCoursSuivi coursSuividao;
	public InterfaceEnseignantSuivis enseignantsuividao;
	public InterfaceResource resourcedao;
	public InterfaceClasse classeDAO;
	public InterfaceFiliere filiereDAO;
	public InterfaceClubSuivi clubsuiviDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetInfoEtudiant() {
		super();
		clubsuiviDAO = new ClubSuiviDAO();
		etudiantdao = new EtudiantDAO();
		coursSuividao = new CoursSuiviDAO();
		enseignantsuividao = new EenseignatSuiviDAO();
		resourcedao = new ResourceDAO();
		classeDAO = new ClasseDAO();
		filiereDAO = new FiliereDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// spring
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("login")==null)
		{
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

		}else{
			System.out.println(session.getAttribute("etudiantin"));
			int idetudiant;
			if(session.getAttribute("etudiantin")!=null)
		 idetudiant=(int)session.getAttribute("etudiantin");
			else {
			
				idetudiant=Integer.parseInt(request.getParameter("idetud"));
			}
		System.out.println("dddddddddddddd"+idetudiant);
		Etudiant etudiant = etudiantdao.getEtudiantById(idetudiant);
		Classe classe = classeDAO.getClasseById(etudiant.getIdclass());
		Filiere filiere = filiereDAO.getFiliereById(classe.getIdfiliere());

		Resource emplois = resourcedao.getResourceByIdType(classe.getIdEmploit(), "emplois");
		Resource note = resourcedao.getResourceByIdType(etudiant.getIdnote(), "note");
		List<Clubs> clubses = clubsuiviDAO.getclubByEtudiant(etudiant.getIdetudiant());
		// Et la date de publi.cation aussi
		List<Cours> courses = coursSuividao.getCoursByEtudiant(etudiant.getIdetudiant());
		List<Enseignant> enseignants = enseignantsuividao.getEnseignantByEtudiant(etudiant.getIdetudiant());
		request.setAttribute("enseignants", enseignants);
		System.out.println(enseignants.size());
		request.setAttribute("classe", classe);
		request.setAttribute("emplois", emplois);
		request.setAttribute("etud", etudiant);
		request.setAttribute("filier", filiere);
		request.setAttribute("courses", courses);
		request.setAttribute("note", note);
		request.setAttribute("clubs", clubses);
		System.out.println(" qlsdcjqs odcjmqsdcnm "+clubses.size());

		/* On appelle la JSP pour affichage du formulaire */
		getServletContext().getRequestDispatcher("/etudiantprofil.jsp").forward(request, response);
		}
	}

}
