package session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSet;

import interfaceentity.InterfaceClasse;
import metier.Classe;
import metier.SingletonConnection;

public class ClasseDAO implements InterfaceClasse {

	Connection conn = null;

	@Override
	public void setClasse(Classe c) {
		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement("insert into classe(	idclasse,idfiliere,nomClasse,idemploit) values (?,?,?,?)");
			ps.setInt(2, c.getIdfiliere());
			ps.setInt(1, c.getIdclasse());
			ps.setString(3, c.getNomClasse());
			ps.setInt(4, c.getIdEmploit());
			int rs = ps.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Classe> getAllClasse() {
		conn = SingletonConnection.getConnection();
		List<Classe> classe = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from classe");

			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				Classe c = new Classe();
				c.setIdclasse(rs.getInt("idclasse"));
				c.setIdfiliere(rs.getInt("idfiliere"));
				c.setNomClasse(rs.getString("nomClasse"));
				c.setIdEmploit(rs.getInt("idemploit"));
				classe.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return classe;
	}

	@Override
	public Classe getClasseById(int id) {
		conn = SingletonConnection.getConnection();
		Classe c = new Classe();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from classe where idclasse like ?");
			ps.setString(1, "%" + id + "%");
			ResultSet rs = (ResultSet) ps.executeQuery();
			rs.next();
			c.setIdclasse(rs.getInt("idclasse"));
			c.setIdfiliere(rs.getInt("idfiliere"));
			c.setNomClasse(rs.getString("nomClasse"));
			c.setIdEmploit(rs.getInt("idemploit"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public void updateClasse(Classe u) {
		conn = SingletonConnection.getConnection();

		String updateTableSQL = "UPDATE classe SET   idfiliere = ? ,nomClasse = ? ,	idemploit=? WHERE idclasse = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(updateTableSQL);

			preparedStatement.setInt(1, u.getIdfiliere());
			preparedStatement.setString(2, u.getNomClasse());
			preparedStatement.setInt(3,u.getIdEmploit());
			preparedStatement.setInt(4, u.getIdclasse());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delateClasse(Classe u) {
		conn = SingletonConnection.getConnection();

		String deleteSQL = "DELETE from classe WHERE idclasse = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, u.getIdclasse());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
