package session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSet;

import interfaceentity.InterfaceSujet;
import metier.SingletonConnection;
import metier.Sujet;

public class SujetDAO implements InterfaceSujet {
	Connection conn = null;

	@Override
	public void setSujet(Sujet s) {
		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement("insert into sujet(titre,iduser,description,categorie) values (?,?,?,?)");
			ps.setString(1, s.getTitre());
			ps.setInt(2, s.getIduser());
			ps.setString(3, s.getDescription());
			ps.setString(4, s.getCategorie());
			int rs = ps.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Sujet> getAllSujet() {
		conn = SingletonConnection.getConnection();
		List<Sujet> sujets = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from sujet");

			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				Sujet s = new Sujet();
				s.setIdSujet(rs.getInt("idSujet"));
				s.setIduser(rs.getInt("iduser"));
				s.setTitre(rs.getString("titre"));
				s.setDescription(rs.getString("description"));
				s.setCategorie(rs.getString("categorie"));
				sujets.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return sujets;
	}

	@Override
	public Sujet getSujetById(int id ) {
		conn = SingletonConnection.getConnection();
		Sujet s = new Sujet();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from sujet where idSujet like ?");
			ps.setString(1, "%" + id + "%");
			ResultSet rs = (ResultSet) ps.executeQuery();
			rs.next();
			s.setIdSujet(id);
			s.setTitre(rs.getString("titre"));
			s.setDescription(rs.getString("description"));
			s.setIduser(rs.getInt("iduser"));
			s.setCategorie(rs.getString("categorie"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
	}

	@Override
	public void updateSujet(Sujet u) {
		conn = SingletonConnection.getConnection();

		String updateTableSQL = "UPDATE sujet SET titre = ? ,iduser = ?,description=?,categorie=? WHERE IdSujet = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, u.getTitre());
			preparedStatement.setInt(2, u.getIduser());
			preparedStatement.setString(3, u.getDescription());
			preparedStatement.setString(4, u.getCategorie());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delateSujet(Sujet u) {
		conn =SingletonConnection.getConnection();

		String deleteSQL = "DELETE from sujet WHERE idSujet = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, u.getIdSujet());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
