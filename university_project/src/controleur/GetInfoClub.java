package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaceentity.InterfaceActivity;
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
import metier.Activity;
import metier.Classe;
import metier.Clubs;
import metier.Cours;
import metier.CoursSuivis;
import metier.Enseignant;
import metier.EnseignantSuivis;
import metier.Etudiant;
import metier.Filiere;
import metier.Resource;
import session.ActivityDAO;
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
@WebServlet("/GetInfoClub")
public class GetInfoClub extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public InterfaceClubs clubsdao;
	public InterfaceClubSuivi clubSuivi;
	public InterfaceActivity activitieDAO;
	public InterfaceEnseignant enseignantDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetInfoClub() {
		super();
		clubsdao = new ClubsDAO();
		clubSuivi = new ClubSuiviDAO();
		activitieDAO = new ActivityDAO();
		enseignantDAO = new EnseignantDAO();
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
		String serialNb = request.getParameter("idc");
		Clubs club;

		String idac = request.getParameter("idac");
		club = clubsdao.getClubById(Integer.parseInt(serialNb));

		Enseignant enseignant = enseignantDAO.getEnseignantById(club.getIdencadreur());
		Activity activity;
		if (idac == null)
			activity = activitieDAO.getActivityById(club.getIdActivity());
		else
			activity = activitieDAO.getActivityById(Integer.parseInt(idac));
		System.out.println("ffffffffffffffff"+idac);
		List<Activity> activities = activitieDAO.getAllActivity();
		List<Activity> activities1 = new ArrayList<>();
		for (int i = 0; i < activities.size(); i++) {
			if (activities.get(i).getIdclub() == club.getIdclub()) {
				activities1.add(activities.get(i));
			}

		}
		// Et la date de publi.cation aussi

		request.setAttribute("club", club);
		request.setAttribute("enseignant", enseignant);
		request.setAttribute("activity", activity);
		request.setAttribute("activities", activities1);

		/* On appelle la JSP pour affichage du formulaire */
		getServletContext().getRequestDispatcher("/clubprofil.jsp").forward(request, response);

	}

}
