package session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

import interfaceentity.InterfaceEntreprise;
import metier.ConnectionDataBase;
import metier.Entreprise;
import metier.User;

public class EntrepriseDAO implements InterfaceEntreprise{
	Connection conn=null;
	@Override
	public void setEnseignant(Entreprise u) {
		conn = ConnectionDataBase.getConnection();
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Entreprise> getAllEnseignant() {
		conn = ConnectionDataBase.getConnection();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User LoginEnseignant(String login, String password) {
		
		conn =ConnectionDataBase.getConnection();
		//String	requette="select * from etudiant where idetudiant like ? ";
	String	requette2="select * from user where password like ? and login like ? ";
		PreparedStatement ps = null;
		try {
			ps=conn.prepareStatement(requette2);
		   ps.setString(1, password);
		   ps.setString(2, login);
		  
			ResultSet rs =ps.executeQuery();
		
			
		ResultSetMetaData md = rs.getMetaData() ;
		 int columnCount = md.getColumnCount() ;
		 if (columnCount >0){
		User e = null;
			 while (rs.next()) {
			  e=new User();
			 			  
			 e.setNomuser(rs.getString("nomuser"));
			e.setTelephone(rs.getString("telephone"));
			e.setLogin(rs.getString("login"));
			
			e.setEmail(rs.getString("email"));
			e.setPrenom(rs.getString("prenom"));
			e.setIduser(rs.getInt("iduser"));
			e.setPassword(rs.getString("password"));
			
			 } 
		                
			 return e;
		 }
		 
		} catch (Exception exp) {
			System.out.println("ereeeeeeeur");
			exp.printStackTrace();
		}
		return null;
	}

	@Override
	public Entreprise getEnseignantById(int id) {
		conn = ConnectionDataBase.getConnection();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEnseignant(Entreprise u) {
		conn = ConnectionDataBase.getConnection();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delateEnseignant(Entreprise u) {
		conn = ConnectionDataBase.getConnection();
		// TODO Auto-generated method stub
		
	}

}
