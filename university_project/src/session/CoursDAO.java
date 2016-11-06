package session;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSet;

import interfaceentity.InterfaceCours;
import metier.Cours;
import metier.SingletonConnection;

public class CoursDAO implements InterfaceCours {
	Connection conn = null;

	@Override
	public void setCours(Cours c) {
		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement(
					"insert into cours(codeMatiere,NomCours,urlcours,descriptionCours,DateDepotCours) values (?,?,?,?,NOW())");
			ps.setInt(1, c.getCodeMatiere());
			ps.setString(2, c.getNomCours());
			ps.setString(3, c.getUrlcours());
			ps.setString(4, c.getDescriptionCours());
			//ps.setDate(5, (Date) c.getDateDepotCours());
			int rs = ps.executeUpdate();
			System.out.println(c.getCodeMatiere());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Cours> getAllCours() {
		conn = SingletonConnection.getConnection();
		List<Cours> cours = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from  ours");

			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				Cours c = new Cours();
				c.setIdcours(rs.getInt("idcours"));
				c.setCodeMatiere(rs.getInt("codeMatiere"));
				c.setNomCours(rs.getString("NomCours"));
				c.setDescriptionCours(rs.getString("descriptionCours"));
				c.setUrlcours(rs.getString("urlcours"));
				c.setDateDepotCours(rs.getDate("DateDepotCours"));
				cours.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return cours;
	}

	@Override
	public Cours getCoursById(int id) {
		conn = SingletonConnection.getConnection();
		Cours c = new Cours();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from cours where idcours like ?");
			ps.setString(1, "%" + id + "%");
			ResultSet rs = (ResultSet) ps.executeQuery();
			c.setIdcours(rs.getInt("idcours"));
			c.setCodeMatiere(rs.getInt("codeMatiere"));
			c.setNomCours(rs.getString("NomCours"));
			c.setDescriptionCours(rs.getString("descriptionCours"));
			c.setUrlcours(rs.getString("urlcours"));
			c.setDateDepotCours(rs.getDate("DateDepotCours"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public void updateCours(Cours u) {
		conn = SingletonConnection.getConnection();

		String updateTableSQL = "UPDATE cours SET codeMatiere = ? ,nomCours = ?, urlcours=? ,descriptionCours=?,dateDepotCours=? WHERE Idclub = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(updateTableSQL);

			preparedStatement.setInt(1, u.getCodeMatiere());
			preparedStatement.setString(2, u.getNomCours());
			preparedStatement.setString(3, u.getUrlcours());
			preparedStatement.setString(4, u.getDescriptionCours());
			preparedStatement.setDate(5, (Date) u.getDateDepotCours());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delateCours(Cours u) {
		conn = SingletonConnection.getConnection();

		String deleteSQL = "DELETE from cours WHERE idcours = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, u.getIdcours());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Cours> getCoursByEnseignant(int id) {
		conn = SingletonConnection.getConnection();
		List<Cours> courses = new ArrayList<>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from cours where idenseignat like ?");
			ps.setString(1, "%" + id + "%");
			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				Cours c = new Cours();

				c.setIdcours(rs.getInt("idcours"));
				c.setCodeMatiere(rs.getInt("codeMatiere"));
				c.setNomCours(rs.getString("NomCours"));
				c.setDescriptionCours(rs.getString("descriptionCours"));
				c.setUrlcours(rs.getString("urlcours"));
				c.setDateDepotCours(rs.getDate("DateDepotCours"));
				courses.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return courses;
	}

}
