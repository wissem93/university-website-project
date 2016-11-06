package session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSet;

import interfaceentity.InterfaceComentaire;
import metier.Commentaire;
import metier.ConnectionDataBase;
import metier.SingletonConnection;


public class CommentaireDAO implements InterfaceComentaire{
	Connection conn = null;

	

	@Override
	public void setcommentaire(Commentaire c) {
		conn =SingletonConnection.getConnection();

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement("insert into commentaire(iduser,textCom,idSujet) values (?,?,?)");
			ps.setInt(1, c.getIduser());
			ps.setString(2, c.getTextCom());
			ps.setInt(3, c.getIdSujet());
			int rs = ps.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Commentaire> getAllcommentaire() {
		conn =SingletonConnection.getConnection();
		List<Commentaire> commentaires = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from commentaire");

			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				Commentaire commentaire = new Commentaire();
				commentaire.setIdcommentaire(rs.getInt("idcommentaire"));
				commentaire.setIduser(rs.getInt("iduser"));
				commentaire.setTextCom(rs.getString("textCom"));
				commentaire.setIdSujet(rs.getInt("idSujet"));
				commentaires.add(commentaire);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return commentaires;
	}

	@Override
	public Commentaire getcommentaireById(int id) {
		conn =SingletonConnection.getConnection();
		Commentaire commentaire = new Commentaire();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from commentaire where idcommentaire like ?");
			ps.setString(1, "%" + id + "%");
			ResultSet rs = (ResultSet) ps.executeQuery();
			commentaire.setIdcommentaire(rs.getInt("idcommentaire"));
			commentaire.setIduser(rs.getInt("iduser"));
			commentaire.setTextCom(rs.getString("textCom"));
			commentaire.setIdSujet(rs.getInt("idSujet"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return commentaire;
	}

	@Override
	public void updatecommentaire(Commentaire u) {
		conn =SingletonConnection.getConnection();

		String updateTableSQL = "UPDATE commentaire SET iduser = ? ,textCom = ?,idSujet=?  WHERE idcommentaire = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(updateTableSQL);

			preparedStatement.setInt(1, u.getIduser());
			preparedStatement.setString(2, u.getTextCom());
			preparedStatement.setInt(3, u.getIdSujet());
			preparedStatement.setInt(4, u.getIdcommentaire());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delatecommentaire(Commentaire u) {
		conn =ConnectionDataBase.getConnection();

		String deleteSQL = "DELETE from commentaire WHERE idcommentaire = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, u.getIdcommentaire());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
