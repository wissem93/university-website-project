package session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaceentity.InterfaceEtudiant;
import metier.ConnectionDataBase;
import metier.Etudiant;

public class EtudiantDAO implements InterfaceEtudiant {
	java.sql.Connection conn = null;

	@Override
	public void setEtudiant(Etudiant e) {

		conn = ConnectionDataBase.getConnection();

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("insert into user(iduser,nomuser,prenom,login,password,telephone,email) values (?,?,?,?,?,?,?)");
			ps.setInt(1, e.getIduser());
			ps.setString(2, e.getNomuser());
			ps.setString(3, e.getPrenom());
			ps.setString(4, e.getLogin());
			ps.setString(5, e.getPassword());
			ps.setString(6, e.getTelephone());
			ps.setString(7, e.getEmail());
			
			ps.executeUpdate();
			ps = conn.prepareStatement(
					"insert into etudiant(idetudiant ,idclass,idnote)values (?,?,?)");
			ps.setInt(1, e.getIdetudiant());
			ps.setInt(2, e.getIdclass());	
			ps.setInt(3,e.getIdnote());
			int rs = ps.executeUpdate();
			System.out.println(rs);
		} catch (SQLException l) {
			// TODO Auto-generated catch block
			l.printStackTrace();
		}

	}

	@Override
	public List<Etudiant> getAllEtudiant() {
		conn = ConnectionDataBase.getConnection();
		List<Etudiant> etudiants = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from  etudiant,user where idetudiant=iduser ");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Etudiant a = new Etudiant();
				a.setIduser(rs.getInt("iduser"));
				System.out.println(rs.getInt("iduser"));
				a.setNomuser(rs.getString("nomuser"));
				a.setPrenom(rs.getString("prenom"));
				a.setIdetudiant(rs.getInt("idetudiant"));
				a.setIdclass(rs.getInt("Idclass"));
			    a.setEmail(rs.getString("email"));
				a.setLogin(rs.getString("login"));
				a.setTelephone(rs.getString("telephone"));
				a.setPassword(rs.getString("password"));
				a.setIdnote(rs.getInt("idnote"));
				
				etudiants.add(a);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return etudiants;
	}

	@Override
	public Etudiant getEtudiantById(int id) {
		conn = ConnectionDataBase.getConnection();
		Etudiant etudiant = new Etudiant();
		PreparedStatement ps1;
		PreparedStatement ps;
		try {
			ps1 = conn.prepareStatement("select * from user where iduser like ?  ");
			ps1.setInt(1, id );
			ResultSet rs = ps1.executeQuery();
			rs.next();
			etudiant.setIduser(rs.getInt("iduser"));
			etudiant.setNomuser(rs.getString("nomuser"));
			etudiant.setPrenom(rs.getString("prenom"));
			etudiant.setLogin(rs.getString("login"));
			etudiant.setTelephone(rs.getString("telephone"));
			etudiant.setPassword(rs.getString("password"));
			etudiant.setEmail(rs.getString("email"));
			//**********
			ps = conn.prepareStatement("select* from etudiant where idetudiant like ?  ");
			ps.setInt(1, id );
			ResultSet rs1 = ps.executeQuery();
			rs1.next();
			etudiant.setIdetudiant(rs1.getInt("idetudiant"));
			etudiant.setIdclass(rs1.getInt("Idclass"));
			etudiant.setIdnote(rs1.getInt("idnote"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

		return etudiant;
	}

	@Override
	public void updateEtudiant(Etudiant e) {
	
		conn = ConnectionDataBase.getConnection();

		String updateadminSQL = "UPDATE etudiant SET  idclass =? ,idnote=? WHERE idetudiant = ? ";
        String upsateuser= "UPDATE user SET  nomuser = ? , Prenom = ?,login = ? ,password = ?,telephone=? ,email=? iduser=?  ";
		PreparedStatement preparedStatement;
		PreparedStatement preparedStatement2;
		try {
			preparedStatement = conn.prepareStatement(updateadminSQL);
			
			preparedStatement.setInt(2, e.getIdnote());
			preparedStatement.setInt(1, e.getIdclass());
			preparedStatement.setInt(3, e.getIdetudiant());
			preparedStatement.executeUpdate();
			preparedStatement2=conn.prepareStatement(upsateuser);
			preparedStatement2.setString(1, e.getNomuser());
			preparedStatement2.setString(2, e.getPrenom());
			preparedStatement2.setString(3, e.getLogin());
			preparedStatement2.setString(4, e.getPassword());
			preparedStatement2.setString(5, e.getTelephone());
			
			preparedStatement2.setString(6, e.getEmail());
			preparedStatement2.setInt(7, e.getIduser());
			
			preparedStatement2.setInt(8, e.getIduser());
			preparedStatement2.executeUpdate();
		} catch (SQLException o) {
			// TODO Auto-generated catch block
			o.printStackTrace();
		}

	}

	@Override
	public void delateEtudiant(Etudiant e) {
		conn = ConnectionDataBase.getConnection();

		String deletetudientSQL = "DELETE from etudiant WHERE idetudiant = ? ";
		String deleteuserSQL = "DELETE from user WHERE iduser = ? ";

		PreparedStatement preparedStatement;
		try {
		

			preparedStatement = conn.prepareStatement(deletetudientSQL);

			preparedStatement.setInt(1, e.getIdetudiant());

			preparedStatement.executeUpdate();
			preparedStatement = conn.prepareStatement(deleteuserSQL);

			preparedStatement.setInt(1, e.getIduser());

			preparedStatement.executeUpdate();
		} catch (SQLException d) {
			// TODO Auto-generated catch block
			d.printStackTrace();
		}
	}

	@Override
	public boolean LoginEtudiant(String login, String password) {
		conn =ConnectionDataBase.getConnection();
		//Etudiant e = null;

	String	requette2="select * from user  where password like ? and login like ? ";
//	String	requette="select * from etudiant where idetudiant like ? ";
		PreparedStatement ps1,ps = null;
		try {
			ps=conn.prepareStatement(requette2);
		   ps.setString(1, password);
		   ps.setString(2, login);
			ResultSet rs =ps.executeQuery();
		//	ResultSet rs2;
			
		ResultSetMetaData md = rs.getMetaData() ;
		 int columnCount = md.getColumnCount() ;
		 if (columnCount >0){
			 return true;
		 }
		/*	 while (rs.next()) {
			  e=new Etudiant();
			 			  
			 e.setNomuser(rs.getString("nomuser"));
			e.setTelephone(rs.getString("telephone"));
			e.setLogin(rs.getString("login"));
			
			e.setEmail(rs.getString("email"));
			e.setPrenom(rs.getString("prenom"));
			e.setIduser(rs.getInt("iduser"));
			e.setPassword(rs.getString("password"));
			 } 
			 ps1=conn.prepareStatement(requette);
			 ps1.setInt(1, e.getIduser());
				rs2 =ps1.executeQuery();
			 while (rs2.next())
		     {e.setIdclass(rs.getInt("idclasse"));
			 e.setIdetudiant(rs2.getInt("idetudiant"));}

			 return true;
		 }*/
		 
		} catch (Exception exp) {
			System.out.println("ereeeeeeeur");
			exp.printStackTrace();
		}
		return false;
	}

}
