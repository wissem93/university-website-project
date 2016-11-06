package session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaceentity.InterfaceAdmin;
import metier.Admin;
import metier.SingletonConnection;

public class AdminDAO implements InterfaceAdmin {

	java.sql.Connection conn = null;

	public List<Admin> getAllAdmin() {

		conn = SingletonConnection.getConnection();
		List<Admin> admins = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from user , admin where iduser=idAdmin ");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Admin a = new Admin();
				a.setIduser(rs.getInt("iduser"));
				a.setNomuser(rs.getString("nomuser"));
				a.setPrenom(rs.getString("prenom"));
				a.setIdAdmin(rs.getInt("idAdmin"));
				a.setLogin(rs.getString("login"));
				admins.add(a);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return admins;
	}

	@Override
	public void setAdmin(Admin a) {

		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into user(iduser,nomuser,prenom) values (?,?,?)");
			ps.setInt(1, a.getIduser());
			ps.setString(2, a.getNomuser());
			ps.setString(3, a.getPrenom());
			ps.executeUpdate();
			ps = conn.prepareStatement("insert into admin(IdAdmin,login) values (?,?)");
			ps.setInt(1, a.getIdAdmin());
			ps.setString(2, a.getLogin());
			int rs = ps.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Admin getAdminById(int id) {
		conn = SingletonConnection.getConnection();
		Admin admin = new Admin();
		PreparedStatement ps1;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from User where Iduser like ?");
			ps.setString(1, "%" + id + "%");
			ResultSet rs = ps.executeQuery();
			rs.next();
			admin.setIduser(rs.getInt("iduser"));
			admin.setNomuser(rs.getString("nomuser"));
			admin.setPrenom(rs.getString("prenom"));

			ps1 = conn.prepareStatement("select* from admin where idadmin like ?");
			ps1.setString(1, "%" + id + "%");
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			admin.setIdAdmin(rs1.getInt("idadmin"));
			admin.setLogin(rs1.getString("login"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return admin;
	}

	@Override
	public void updateAdmin(Admin a) {
		conn = SingletonConnection.getConnection();

		String updateuserSQL = "UPDATE user SET nomuser = ? , Prenom = ? WHERE iduser = ?";
		String updateadminSQL = "UPDATE admin SET login = ?  WHERE idadmin = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(updateuserSQL);

			preparedStatement.setString(1, a.getNomuser());
			preparedStatement.setString(2, a.getPrenom());
			preparedStatement.setInt(3, a.getIduser());
			preparedStatement.executeUpdate();

			preparedStatement = conn.prepareStatement(updateadminSQL);
			preparedStatement.setInt(1, a.getIdAdmin());
			preparedStatement.setString(2, a.getLogin());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delateAdmin(Admin a) {
		conn = SingletonConnection.getConnection();

		String deleteSQL = "DELETE from user WHERE iduser = ?";
		String deleteadminSQL = "DELETE from admin WHERE idadmin = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, a.getIduser());

			preparedStatement.executeUpdate();

			preparedStatement = conn.prepareStatement(deleteadminSQL);

			preparedStatement.setInt(1, a.getIdAdmin());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
