package interfaceentity;

import java.util.List;

import metier.ClubSuivi;
import metier.Clubs;
import metier.Etudiant;

public interface InterfaceClubSuivi {

	
		
		 public void setClubsuivi(ClubSuivi c);
		 public List<Clubs> getclubByEtudiant(int idEtudiant);
		 public List<Etudiant> getetudiantByClub(int idclub);
		 public ClubSuivi getClubsuiviById(int idetudiant,int idclub);
		 public void delateClubsuivi(ClubSuivi u);
	

}
