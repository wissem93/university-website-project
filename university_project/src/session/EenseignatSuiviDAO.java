package session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import interfaceentity.InterfaceEnseignantSuivis;
import metier.Cours;
import metier.CoursSuivis;
import metier.Enseignant;
import metier.EnseignantSuivis;
import metier.Etudiant;
import metier.SingletonConnection;

public class EenseignatSuiviDAO implements InterfaceEnseignantSuivis {
	java.sql.Connection conn = null;

	@Override
	public void setEnseignantSuivis(EnseignantSuivis c) {
		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into enseignant_suivi(idenseignantsuivi,idetudiant) values (?,?)");
			ps.setInt(1, c.getIdenseignantsuivi());
			ps.setInt(2, c.getIdetudiant());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Enseignant> getEnseignantByEtudiant(int idEtudiant) {

		conn = SingletonConnection.getConnection();
		List<Enseignant> enseignants = new ArrayList<>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(
					"select* from user, enseignant_suivi ,enseignant where enseignant_suivi.idenseignantsuivi =enseignant.idenseignant  and iduser=idenseignant and idetudiant = ?");
			ps.setString(1, "" + idEtudiant);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Enseignant a = new Enseignant();
				a.setIduser(rs.getInt("iduser"));
				a.setNomuser(rs.getString("nomuser"));
				a.setPrenom(rs.getString("prenom"));

				a.setIdenseignant(rs.getInt("idEnseignant"));
				a.setIdmatier(rs.getInt("Idmatier"));
				a.setGradeEnseignant(rs.getString("gradeEnseignant"));
				a.setLogin(rs.getString("login"));
				a.setTelephone(rs.getString("telephone"));
				a.setPassword(rs.getString("password"));
				a.setIdemplois(rs.getInt("idemploi"));
				enseignants.add(a);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return enseignants;

	}

	@Override
	public List<Etudiant> getEtudiantByEnseignant(int idEnseignant) {
		conn = SingletonConnection.getConnection();
		List<Etudiant> etudiants = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement(
					"select * from user , etudiant , enseignant_suivi where enseignant_suivi.idetudiant =etudiant.idetudiant and iduser=etudiant.idetudiant and enseignant_suivi.idenseignantsuivi = ?  ");
			System.out.println("ccccccccccccccc");
			ps.setString(1, "" + idEnseignant);

			ResultSet rs = ps.executeQuery();
			System.out.println("llllllllllllllllllll");

			while (rs.next()) {
				Etudiant a = new Etudiant();
				a.setIduser(rs.getInt("iduser"));
				a.setNomuser(rs.getString("nomuser"));
				a.setPrenom(rs.getString("prenom"));

				a.setIdetudiant(rs.getInt("idetudiant"));
				a.setIdclass(rs.getInt("Idclass"));
				a.setLogin(rs.getString("login"));
				a.setTelephone(rs.getString("telephone"));
				a.setPassword(rs.getString("password"));
				a.setIdetudiant(rs.getInt("idetudiant"));
				etudiants.add(a);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return etudiants;

	}

	@Override
	public EnseignantSuivis getEnseignantSuivisById(int idetudiant, int idEnseignant) {
		conn = SingletonConnection.getConnection();
		PreparedStatement ps;
		EnseignantSuivis enseignantSuivis = new EnseignantSuivis();

		try {
			ps = conn.prepareStatement(
					"select* from enseignant_suivi where enseignant_suivi.idetudiant = ? and enseignant_suivi.idenseignantsuivi = ?");
			ps.setString(1, " idetudiant");
			ps.setString(2, "idenseignantsuivi");
			ResultSet rs = ps.executeQuery();
			enseignantSuivis.setIdenseignantsuivi(rs.getInt("idenseignantsuivi"));
			enseignantSuivis.setIdetudiant(rs.getInt("idetudiant"));

		} catch (Exception exception) {
			exception.getMessage();
		}

		return enseignantSuivis;
	}

	@Override
	public void delateEnseignantSuivis(EnseignantSuivis u) {

		conn = SingletonConnection.getConnection();

		String deleteSQL = "DELETE from cours_suivis WHERE idenseignantsuivi = ? and idetudiant=?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, u.getIdenseignantsuivi());
			preparedStatement.setInt(2, u.getIdetudiant());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
