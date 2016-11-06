package session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSet;

import interfaceentity.InterfaceMatiere;
import metier.Matiere;
import metier.SingletonConnection;

public class MatiereDAO implements InterfaceMatiere {

	Connection conn = null;

	@Override
	public void setMatiere(Matiere s) {
		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement("insert into matiere(NomMatiere) values (?)");
			ps.setString(1, s.getNomMatiere());

			int rs = ps.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Matiere> getAllMatiere() {
		conn = SingletonConnection.getConnection();
		List<Matiere> matiere = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from matiere");

			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				Matiere m = new Matiere();
				m.setIdmatiere(rs.getInt("idmatiere"));
				m.setNomMatiere(rs.getString("NomMatiere"));

				matiere.add(m);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return matiere;
	}

	@Override
	public Matiere getMatiereById(int id) {
		conn = SingletonConnection.getConnection();
		Matiere m = new Matiere();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from matiere where idmatiere like ?");
			ps.setString(1, "%" + id + "%");
			ResultSet rs = (ResultSet) ps.executeQuery();
			m.setIdmatiere(rs.getInt("ifiliere"));
			m.setNomMatiere(rs.getString("NomFiliere"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return m;
	}

	@Override
	public void updateMatiere(Matiere u) {
		conn = SingletonConnection.getConnection();

		String updateTableSQL = "UPDATE matiere SET NomMatiere = ? WHERE idmatiere = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, u.getNomMatiere());
			preparedStatement.setInt(2, u.getIdmatiere());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delateMatiere(Matiere u) {
		conn = SingletonConnection.getConnection();

		String deleteSQL = "DELETE from matiere WHERE idmatiere = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, u.getIdmatiere());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
