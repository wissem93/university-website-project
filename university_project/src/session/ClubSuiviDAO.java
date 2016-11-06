package session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaceentity.InterfaceClubSuivi;
import metier.ClubSuivi;
import metier.Clubs;
import metier.Cours;
import metier.Etudiant;
import metier.SingletonConnection;

public class ClubSuiviDAO  implements InterfaceClubSuivi {
	java.sql.Connection conn = null;

	@Override
	public void setClubsuivi(ClubSuivi c) {
		conn = SingletonConnection.getConnection();

		PreparedStatement ps;
		try {	
			ps = conn.prepareStatement("insert into cours_suivis(idclub,idetudiant) values (?,?)");
			ps.setInt(1, c.getIdclub());
			ps.setInt(2, c.getIdetudiant());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}


	@Override
	public ClubSuivi getClubsuiviById(int idetudiant, int idclub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delateClubsuivi(ClubSuivi u) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Clubs> getclubByEtudiant(int idEtudiant) {
		conn = SingletonConnection.getConnection();
		List<Clubs> clubses = new ArrayList<>();
		PreparedStatement ps;
		try {
			System.out.println(idEtudiant);
			ps = conn.prepareStatement("select * from clubs ,clubsuivi  where  idclubsuivi=clubs.idclub and  clubsuivi.idetudiant = 3");
			//ps.setString(1,""+idEtudiant);
		 
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				Clubs c = new Clubs();
				c.setIdclub(rs.getInt("idclub"));
				c.setNom(rs.getString("nom"));
				c.setCaractere(rs.getString("caractere"));
				c.setIdActivity(rs.getInt("idActivity"));
				c.setIdencadreur(rs.getInt("idencadreur"));
				clubses.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return clubses;
	}


	@Override
	public List<Etudiant> getetudiantByClub(int idclub) {
		// TODO Auto-generated method stub
		return null;
	}



}
