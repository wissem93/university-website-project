package session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaceentity.InterfaceEnseignant;
import metier.Enseignant;
import metier.SingletonConnection;

public class EnseignantDAO implements InterfaceEnseignant {
	java.sql.Connection conn = null;

	@Override
	public void setEnseignant(Enseignant e) {
		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into user(iduser,nomuser,prenom) values (?,?,?)");
			ps.setInt(1, e.getIduser());
			ps.setString(2, e.getNomuser());
			ps.setString(3, e.getPrenom());
			ps.executeUpdate();
			ps = conn.prepareStatement(
					"insert into Enseignant(idEnseignant,login,password,telephone,Idmatier,GradeEnseignant,idemplois)values (?,?,?,?,?,?,?)");
			ps.setInt(1, e.getIdenseignant());
			ps.setString(2, e.getLogin());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getTelephone());
			ps.setInt(5, e.getIdmatier());
			ps.setString(6, e.getGradeEnseignant());
			ps.setInt(7, e.getIdemplois());
			int rs = ps.executeUpdate();
			System.out.println(rs);
		} catch (SQLException l) {
			// TODO Auto-generated catch block
			l.printStackTrace();
		}

	}

	@Override
	public List<Enseignant> getAllEnseignant() {
		conn = SingletonConnection.getConnection();
		List<Enseignant> enseignants = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from  enseignant,user where idenseignant=iduser");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Enseignant a = new Enseignant();
				a.setIduser(rs.getInt("iduser"));
				a.setNomuser(rs.getString("nomuser"));
				a.setPrenom(rs.getString("prenom"));

				a.setIdenseignant(rs.getInt("idEnseignant"));
				a.setIdmatier(rs.getInt("idmatier"));

				a.setGradeEnseignant(rs.getString("gradeEnseignant"));
				a.setLogin(rs.getString("login"));
				a.setTelephone(rs.getString("telephone"));
				a.setPassword(rs.getString("password"));
				a.setIdemplois(rs.getInt("idemploi"));

				enseignants.add(a);
				System.out.println("iuhlk<jwxclkj<wnck<w"+a.getNomuser());

			}
		} catch (Exception e) {
e.getStackTrace();	

		e.getMessage();}

		return enseignants;
	}

	@Override
	public Enseignant getEnseignantById(int id) {
		conn = SingletonConnection.getConnection();
		Enseignant enseignant = new Enseignant();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from User where Iduser like ?");
			ps.setString(1, "%" + id + "%");
			ResultSet rs = ps.executeQuery();
			rs.first();
			enseignant.setIduser(rs.getInt("iduser"));
			enseignant.setNomuser(rs.getString("nomuser"));
			enseignant.setPrenom(rs.getString("prenom"));
			enseignant.setLogin(rs.getString("login"));

			enseignant.setTelephone(rs.getString("telephone"));
			enseignant.setPassword(rs.getString("password"));
			ps = conn.prepareStatement("select* from enseignant where idenseignant like ?");
			ps.setString(1, "%" + id + "%");
			rs = ps.executeQuery();
			rs.next();
			enseignant.setIdenseignant(rs.getInt("idEnseignant"));
			enseignant.setIdmatier(rs.getInt("Idmatier"));
			enseignant.setGradeEnseignant(rs.getString("gradeEnseignant"));

			enseignant.setIdemplois(rs.getInt("idemploi"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return enseignant;
	}

	@Override
	public void updateEnseignant(Enseignant e) {
		conn = SingletonConnection.getConnection();

		String updateuserSQL = "UPDATE user SET nomuser = ? , Prenom = ? WHERE iduser = ?";
		String updateadminSQL = "UPDATE etudiant SET idEnseignant = ?,loginEnseignant = ?,passwordEnseignant = ?,teleEnseignant = ?,Idmatier = ?,GradeEnseignant = ? , idemplois=? WHERE idetudiant = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(updateuserSQL);

			preparedStatement.setString(1, e.getNomuser());
			preparedStatement.setString(2, e.getPrenom());
			preparedStatement.setInt(3, e.getIduser());
			preparedStatement.executeUpdate();

			preparedStatement = conn.prepareStatement(updateadminSQL);
			preparedStatement.setInt(1, e.getIdenseignant());
			preparedStatement.setString(2, e.getLogin());
			preparedStatement.setString(3, e.getPassword());
			preparedStatement.setString(4, e.getTelephone());
			preparedStatement.setInt(5, e.getIdmatier());
			preparedStatement.setString(6, e.getGradeEnseignant());
			preparedStatement.setInt(7, e.getIdemplois());

			int rs = preparedStatement.executeUpdate();
			System.out.println(rs);
			preparedStatement.executeUpdate();
		} catch (SQLException o) {
			// TODO Auto-generated catch block
			o.printStackTrace();
		}

	}

	@Override
	public void delateEnseignant(Enseignant e) {
		conn = SingletonConnection.getConnection();

		String deleteSQL = "DELETE from user WHERE iduser = ?";
		String deletetudientSQL = "DELETE from enseignant WHERE idenseignant = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, e.getIduser());

			preparedStatement.executeUpdate();

			preparedStatement = conn.prepareStatement(deletetudientSQL);

			preparedStatement.setInt(1, e.getIdenseignant());

			preparedStatement.executeUpdate();
		} catch (SQLException d) {
			// TODO Auto-generated catch block
			d.printStackTrace();
		}
	}

}
