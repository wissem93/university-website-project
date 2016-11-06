package controleur;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Cours;
import session.CoursDAO;

/**
 * Servlet implementation class AddCourSuivi
 */
@WebServlet("/AddCour")
public class AddCour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCour() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		getServletContext().getRequestDispatcher("/addcour.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Cours cour=new Cours();
    cour.setCodeMatiere(Integer.parseInt(request.getParameter("idmatier")));
	cour.setNomCours(request.getParameter("name"));
	System.out.println(cour.getCodeMatiere());
	cour.setUrlcours(request.getParameter("urlcour"));
	cour.setDescriptionCours(request.getParameter("description"));
	CoursDAO coursDAO=new CoursDAO();
	coursDAO.setCours(cour);
	request.getRequestDispatcher("/addcour.jsp").forward(request, response);
		
		
		
		
	}

}
