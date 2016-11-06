package session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaceentity.InterfaceResource;
import metier.Clubs;
import metier.Resource;
import metier.SingletonConnection;

public class ResourceDAO implements InterfaceResource {
	java.sql.Connection conn = null;

	@Override
	public void setResource(Resource r) {
		// TODO Auto-generated method stub
		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {

			ps = conn.prepareStatement("insert into resource(nom,urlRsource,description,type) values (?,?,?,?)");
		//	ps.setInt(1, r.getIdresource());
			ps.setString(1, r.getNom());
			ps.setString(2, r.getUrlRsource());
			ps.setString(3, r.getDescription());
			ps.setString(4,r.getType());
			int rs = ps.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Resource> getAllResource() {
		conn = SingletonConnection.getConnection();
		List<Resource> resources = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from Resource ");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Resource c = new Resource();
				c.setIdresource(rs.getInt("idResource"));
				c.setNom(rs.getString("nom"));
				c.setUrlRsource(rs.getString("urlRsource"));
				c.setDescription(rs.getString("Description"));
				resources.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resources;
	}

	@Override
	public Resource getResourceById(int id) {
		// TODO Auto-generated method stub
		conn = SingletonConnection.getConnection();
		Resource c = new Resource();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from resource where idresource like ?");
			ps.setString(1, "%" + id + "%");
			ResultSet rs = ps.executeQuery();
			rs.next();
			c.setIdresource(rs.getInt("idResource"));
			c.setNom(rs.getString("nom"));
			c.setUrlRsource(rs.getString("urlRsource"));
			c.setDescription(rs.getString("Description"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;	}

	@Override
	public void updateResource(Resource r) {
		conn = SingletonConnection.getConnection();

		String updateTableSQL = "UPDATE resource SET nom = ? ,urlRsource=?,description = ? WHERE Idresource = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(updateTableSQL);

			preparedStatement.setInt(4, r.getIdresource());
			preparedStatement.setString(1, r.getNom());
			preparedStatement.setString(2, r.getUrlRsource());
			preparedStatement.setString(3, r.getDescription());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void delateResource(Resource u) {
		conn = SingletonConnection.getConnection();

		String deleteSQL = "DELETE from resource WHERE Idresource = ?";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareStatement(deleteSQL);

			preparedStatement.setInt(1, u.getIdresource());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Resource getResourceByIdType(int id, String t) {
		conn = SingletonConnection.getConnection();
		Resource c = new Resource();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select* from resource where idresource= ? and type = ?");
			ps.setString(1, "" + id);
			ps.setString(2, "" + t);

			ResultSet rs = ps.executeQuery();
			rs.next();
			c.setIdresource(rs.getInt("idresource"));
			c.setNom(rs.getString("nom"));
			c.setUrlRsource(rs.getString("urlRsource"));
			c.setDescription(rs.getString("Description"));
			c.setType(rs.getString("type"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

}
