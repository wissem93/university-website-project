package session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSet;

import interfaceentity.InterfaceFiliere;
import metier.Filiere;
import metier.SingletonConnection;

public class FiliereDAO implements InterfaceFiliere{

	
	Connection conn = null;
	@Override
	public void setFiliere(Filiere c) {
		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement("insert into filiere(NomFiliere) values (?)");
			ps.setString(1, c.getNomFiliere());
		
			int rs = ps.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Filiere> getAllFiliere() {
		conn = SingletonConnection.getConnection();
		List<Filiere> filiere = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from filiere");

			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				Filiere c =new Filiere();
				c.setIdfiliere(rs.getInt("idfiliere"));
				c.setNomFiliere(rs.getString("NomFiliere"));
			
				filiere.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return filiere;
	}

	@Override
	public Filiere getFiliereById(int id) {
		conn = SingletonConnection.getConnection();
		Filiere f = new Filiere();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from filiere where idfiliere like ?");
			ps.setString(1, "%" + id + "%");
			ResultSet rs = (ResultSet) ps.executeQuery();
			rs.next();
			f.setIdfiliere(rs.getInt("idfiliere"));
			f.setNomFiliere(rs.getString("NomFiliere"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}

	@Override
	public void updateFiliere(Filiere u) {
		conn = SingletonConnection.getConnection();

		String updateTableSQL = "UPDATE filiere SET NomFiliere = ? WHERE idfiliere = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, u.getNomFiliere());
			preparedStatement.setInt(2, u.getIdfiliere());
			

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delateFiliere(Filiere u) {
		conn =SingletonConnection.getConnection();

		String deleteSQL = "DELETE from filiere WHERE idfiliere = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, u.getIdfiliere());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
