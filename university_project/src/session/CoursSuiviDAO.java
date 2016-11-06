package session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaceentity.InterfaceCoursSuivi;
import metier.Cours;
import metier.CoursSuivis;
import metier.Etudiant;
import metier.SingletonConnection;

public class CoursSuiviDAO implements InterfaceCoursSuivi {
	java.sql.Connection conn = null;

	@Override
	public void setCoursSuivis(metier.CoursSuivis c) {
		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into cours_suivis(idcourssuivi,idetudiant) values (?,?)");
			ps.setInt(1, c.getIdcours_suivis());
			ps.setInt(2, c.getIdetudiant());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Cours> getCoursByEtudiant(int idEtudiant) {
		conn = SingletonConnection.getConnection();
		List<Cours> cours = new ArrayList<>();
		PreparedStatement ps;
		try {
			System.out.println(idEtudiant);
			ps = conn.prepareStatement("select * from cours_suivis ,cours where  idcourssuivi=cours.idcours and  cours_suivis.idetudiant = ?");
			ps.setString(1,""+idEtudiant);
		 
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Cours c = new Cours();
				c.setIdcours(rs.getInt("idcours"));
				c.setNomCours(rs.getString("NomCours"));
				c.setCodeMatiere(rs.getInt("codeMatiere"));
				c.setDescriptionCours(rs.getString("descriptionCours"));
				c.setDateDepotCours(rs.getDate("dateDepotCours"));
				c.setUrlcours(rs.getString("urlcours"));
				cours.add(c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}

		return cours;

	}

	@Override
	public List<Etudiant> getCoursByCours(int idcours) {
		conn = SingletonConnection.getConnection();
		List<Etudiant> etudiants = new ArrayList<>();
		PreparedStatement ps;
		PreparedStatement pStatement;
		try {
			ps = conn.prepareStatement("select* from cours_suivis ,cours where cours_suivis.idetudiant=cours.idetudiant and idcours = ?");
			ps.setString(1, "idcours ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Etudiant et = new Etudiant();
				et.setIduser(rs.getInt("iduser"));
				et.setNomuser(rs.getString("nomuser"));
				et.setPrenom(rs.getString("prenom"));

				et.setIdetudiant(rs.getInt("idetudiant"));
				et.setIdclass(rs.getInt("Idclass"));
			
				et.setLogin(rs.getString("login"));
				et.setTelephone(rs.getString("telephone"));
				et.setPassword(rs.getString("password"));
				et.setIdetudiant(rs.getInt("idetudiant"));
				etudiants.add(et);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return etudiants;

	}

	@Override
	public metier.CoursSuivis getCoursSuivisById(int idetudiant, int idcour) {

		conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		CoursSuivis c = new CoursSuivis();

		try {
			ps = conn.prepareStatement("select* from cours_suivis where idetudiant = ? and idcours = ?");
			ps.setString(1, " idetudiant");
			ps.setString(2, "idcours");
			ResultSet rs = ps.executeQuery();
			c.setIdcours_suivis(rs.getInt("idcourssuivi"));
			c.setIdetudiant(rs.getInt("idetudiant"));

		} catch (Exception exception) {
			exception.getMessage();
		}

		return c;
	}

	@Override
	public void delateCoursSuivis(metier.CoursSuivis u) {

		conn = SingletonConnection.getConnection();

		String deleteSQL = "DELETE from cours_suivis WHERE idcourssuivi = ? and idetudiant=?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, u.getIdcours_suivis());
			preparedStatement.setInt(2, u.getIdetudiant());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
