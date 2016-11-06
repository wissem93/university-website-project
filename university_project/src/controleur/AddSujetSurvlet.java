package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Clubs;
import metier.Sujet;

/**
 * Servlet implementation class AddSujetSurvlet
 */
@WebServlet("/AddSujetSurvlet")
public class AddSujetSurvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSujetSurvlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		ModeleAddSujet mod = new ModeleAddSujet();
		Sujet u = new Sujet();
		int idSujet = Integer.parseInt(request.getParameter("idSujet"));
		String titre = request.getParameter("titre");
		int iduser=Integer.parseInt(request.getParameter("iduser"));
		String description=request.getParameter("description");
	 String categorie=request.getParameter("categorie");
		
		u.setIdSujet(idSujet);
		u.setIduser(iduser);
		u.setTitre(titre);
		u.setDescription(description);
		u.setCategorie(categorie);
		mod.setSujet(u);
		// mod.setNomUser(nom);
		// mod.setPrenom(prenom);
		request.getRequestDispatcher("Sujet.jsp").forward(request, response);
	
		
		
	}

}
