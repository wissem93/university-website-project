package session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaceentity.InterfaceClubs;
import metier.Clubs;
import metier.SingletonConnection;

public class ClubsDAO implements InterfaceClubs {
	java.sql.Connection conn = null;

	@Override
	public void setClub(Clubs c) {
		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement("insert into Clubs(nom,Caractere,idActivity,idencadreur) values (?,?,?,?)");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getCaractere());
			ps.setInt(3, c.getIdActivity());
			ps.setInt(4, c.getIdencadreur());
			int rs = ps.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Clubs> getAllClub() {
		conn = SingletonConnection.getConnection();
		List<Clubs> clubs = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from clubs");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Clubs c = new Clubs();
				c.setIdclub(rs.getInt("idclub"));
				c.setNom(rs.getString("nom"));
				c.setCaractere(rs.getString("caractere"));
				c.setIdActivity(rs.getInt("idActivity"));
				c.setIdencadreur(rs.getInt("idencadreur"));
				clubs.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return clubs;

	}

	@Override
	public Clubs getClubById(int id) {
		conn = SingletonConnection.getConnection();
		Clubs c = new Clubs();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from clubs where idclub like ?");
			ps.setString(1, "%" + id + "%");
			ResultSet rs = ps.executeQuery();
			rs.next();
			c.setIdclub(rs.getInt("idclub"));
			c.setNom(rs.getString("nom"));
			c.setCaractere(rs.getString("caractere"));
			c.setIdActivity(rs.getInt("idActivity"));
			c.setIdencadreur(rs.getInt("idencadreur"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public void updateClub(Clubs c) {
		conn = SingletonConnection.getConnection();

		String updateTableSQL = "UPDATE clubs SET nom = ? ,caractere = ?,idActivity=?,idencadreur=? WHERE Idclub = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, c.getNom());
			preparedStatement.setString(2, c.getCaractere());
			preparedStatement.setInt(5, c.getIdclub());
			preparedStatement.setInt(3, c.getIdActivity());
			preparedStatement.setInt(4, c.getIdencadreur());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delateClub(Clubs c) {
		conn = SingletonConnection.getConnection();

		String deleteSQL = "DELETE from clubs WHERE Idclub = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, c.getIdclub());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Clubs> getClubByEnseignant(int id) {
		conn = SingletonConnection.getConnection();
		List<Clubs> clubs = new ArrayList<>();
PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from clubs where idencadreur like ?");
			ps.setString(1, "%" + id + "%");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Clubs c = new Clubs();
				c.setIdclub(rs.getInt("idclub"));
				c.setNom(rs.getString("nom"));
				c.setCaractere(rs.getString("caractere"));
				c.setIdActivity(rs.getInt("idActivity"));
				c.setIdencadreur(rs.getInt("idencadreur"));
				clubs.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return clubs;

	}

}
