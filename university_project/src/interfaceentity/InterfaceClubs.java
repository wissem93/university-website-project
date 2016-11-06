package interfaceentity;

import java.util.List;

import metier.Clubs;
import metier.Cours;

public interface InterfaceClubs {
	
	 public void setClub(Clubs c);
	 public List<Clubs> getAllClub();
	 public Clubs getClubById(int id);
	 public List<Clubs> getClubByEnseignant(int id);
	 public void updateClub(Clubs u);
	 public void delateClub(Clubs u);
}
