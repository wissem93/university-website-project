package session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaceentity.InterfaceActivity;
import metier.SingletonConnection;

public class ActivityDAO implements InterfaceActivity {
	java.sql.Connection conn = null;

	@Override
	public void setActivity(metier.Activity a) {
		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into activity(nom,description,idclub) values (?,?,?)");
			ps.setString(1, a.getNom());
			ps.setString(2, a.getDescription());
			ps.setInt(3, a.getIdclub());
			int rs = ps.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<metier.Activity> getAllActivity() {
		conn = SingletonConnection.getConnection();
		List<metier.Activity> activities = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from activity");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				metier.Activity ac = new metier.Activity();
				ac.setIdactivity(rs.getInt("Idactivity"));
				ac.setNom(rs.getString("nom"));
				ac.setDescription(rs.getString("description"));
				ac.setIdclub(rs.getInt("idclub"));
				activities.add(ac);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return activities;
	}

	@Override
	public metier.Activity getActivityById(int id) {
		conn = SingletonConnection.getConnection();
		metier.Activity activity = new metier.Activity();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from activity where IdActivity like ?");
			ps.setString(1, "%" + id + "%");
			ResultSet rs = ps.executeQuery();
			rs.next();
			activity.setIdactivity(rs.getInt("IdActivity"));
			activity.setNom(rs.getString("nom"));
			activity.setDescription(rs.getString("description"));
			activity.setIdclub(rs.getInt("idclub"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return activity;
	}

	@Override
	public void updateActivity(metier.Activity a) {
		conn = SingletonConnection.getConnection();

		String updateTableSQL = "UPDATE activity SET nom = ? ,Description = ? WHERE Idactivity = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, a.getNom());
			preparedStatement.setString(2, a.getDescription());
			preparedStatement.setInt(3, a.getIdactivity());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delateActivity(metier.Activity a) {
		conn = SingletonConnection.getConnection();

		String deleteSQL = "DELETE from activity WHERE Idactivity = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, a.getIdactivity());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
