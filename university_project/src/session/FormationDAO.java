package session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaceentity.InterfaceFormation;
import metier.ConnectionDataBase;
import metier.Formation;
import metier.SingletonConnection;

public class FormationDAO implements InterfaceFormation {
	Connection conn = null;

	@Override
	public void setFormation(metier.Formation s) {
		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into formation(idfiliere,NomFormation) values (?,?)");
			ps.setInt(1, s.getIdfiliere());
			ps.setString(2, s.getNomFormation());
			int rs = ps.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<metier.Formation> getAllFormation() {
		conn = SingletonConnection.getConnection();
		List<metier.Formation> formations = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from formation");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				metier.Formation formation = new metier.Formation();
				formation.setIdformation(rs.getInt("idformation"));
				formation.setIdfiliere(rs.getInt("idfiliere"));
				formation.setNomFormation(rs.getString("NomFormation"));
				formations.add(formation);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return formations;
	}

	@Override
	public metier.Formation getFormationById(int id) {

		conn = SingletonConnection.getConnection();
		metier.Formation formation = new metier.Formation();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from formation where idformation like ?");
			ps.setString(1, "%" + id + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				formation.setIdformation(rs.getInt("idformation"));
				formation.setIdfiliere(rs.getInt("idfiliere"));
				formation.setNomFormation(rs.getString("NomFormation"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return formation;

	}

	@Override
	public void updateFormation(Formation u) {
		conn = ConnectionDataBase.getConnection();

		String updateTableSQL = "UPDATE formation SET NomFormation = ? , idfiliere = ? WHERE idformation = ?";
		int r = -1;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, u.getNomFormation());
			preparedStatement.setInt(2, u.getIdfiliere());
			preparedStatement.setInt(3, u.getIdformation());

			r = preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println(u.getNomFormation() + "lllllllllllllllllllllllll" + r);

	}

	@Override
	public void delateFormation(metier.Formation u) {
		conn = SingletonConnection.getConnection();

		String deleteSQL = "DELETE from formation WHERE idformation = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, u.getIdformation());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
