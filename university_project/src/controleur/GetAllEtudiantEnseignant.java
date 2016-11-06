package controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaceentity.InterfaceEnseignant;
import interfaceentity.InterfaceEtudiant;
import metier.Enseignant;
import metier.Etudiant;
import session.EnseignantDAO;
import session.EtudiantDAO;

/**
 * Servlet implementation class GetAllEtudiantEnseignant
 */
@WebServlet("/GetAllEtudiantEnseignant")
public class GetAllEtudiantEnseignant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InterfaceEnseignant enseignantDAO;
	InterfaceEtudiant etudiantDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllEtudiantEnseignant() {
		super();
		enseignantDAO = new EnseignantDAO();
		etudiantDAO = new EtudiantDAO();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Etudiant> etudiants = etudiantDAO.getAllEtudiant();
		List<Enseignant> enseignants = enseignantDAO.getAllEnseignant();

		request.setAttribute("etudiants", etudiants);
		request.setAttribute("enseignants", enseignants);
		getServletContext().getRequestDispatcher("/alletudiantensenant.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hgsdckhqsdbclkqsbdclkjsdnkcnsdcnsdcnmqlsdncmqsndcmlkqsjlcqs"+request.getAttribute("emlpoienseign"));
	
	
	
	}

}
