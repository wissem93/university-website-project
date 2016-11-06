package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpsParameters;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

import interfaceentity.InterfaceComentaire;
import interfaceentity.InterfaceEnseignant;
import interfaceentity.InterfaceSujet;
import metier.Commentaire;
import metier.Enseignant;
import metier.Sujet;
import session.CommentaireDAO;
import session.EnseignantDAO;
import session.SujetDAO;

/**
 * Servlet implementation class addcomantaire
 */
@WebServlet("/AddComantaire")
public class AddComantaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InterfaceComentaire comentaireDAO;
	private InterfaceSujet sujetDAO;
	private InterfaceEnseignant enseignantDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddComantaire() {
		super();
		comentaireDAO = new CommentaireDAO();
		sujetDAO = new SujetDAO();
		enseignantDAO = new EnseignantDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String serialNb = request.getParameter("id");

		System.out.println("tag tag = " + ids);
		Sujet s;
		List<Sujet> sujets = sujetDAO.getAllSujet();
		request.setAttribute("sujets", sujets);

		if (serialNb == null) {
			if (ids != 0) {
				s = sujetDAO.getSujetById(ids);
			} else
				s = sujets.get(sujets.size() - 1);
		} else
			    s = sujetDAO.getSujetById(Integer.parseInt(serialNb));

		request.setAttribute("dernieresujet", s);
		Enseignant ens = enseignantDAO.getEnseignantById(s.getIduser());

		request.setAttribute("enseignant", ens);
		System.out.println(s.getIduser()+"ggggggggggggggggggggggggggg" + ens.getIduser());
		List<Commentaire> coms = comentaireDAO.getAllcommentaire();
		List<ModelCommantaireEnseignant> commantaireEnseignants = new ArrayList<>();
		for (int i = 0; i < coms.size(); i++) {
			System.out.println(s.getIdSujet());

			if (coms.get(i).getIdSujet() == s.getIdSujet()) {
				ModelCommantaireEnseignant m = new ModelCommantaireEnseignant();
				m.setC(coms.get(i));
				m.setE(enseignantDAO.getEnseignantById(coms.get(i).getIduser()));
				commantaireEnseignants.add(m);
			}
		}
		request.setAttribute("commantaireEnseignants", commantaireEnseignants);

		getServletContext().getRequestDispatcher("/forum.jsp").forward(request, response);

	}

	int ids = 0;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Commentaire commentaire = new Commentaire();
		HttpSession session = request.getSession();
		// commentaire.setIdcommentaire(Integer.parseInt(request.getParameter("idcommentaire")));
		commentaire.setIdSujet((int) session.getAttribute("sujetsession"));
		
		commentaire.setIduser((int)session.getAttribute("enseingniantin"));
		commentaire.setTextCom(request.getParameter("textCom"));
		comentaireDAO.setcommentaire(commentaire);
		// getServletContext().getRequestDispatcher("/AddComantaire").forward(request,
		// response);
		// request.setAttribute("id1", commentaire.getIdSujet());
		ids = commentaire.getIdSujet();
		doGet(request, response);
	}

}
