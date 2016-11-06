package interfaceentity;

import java.util.List;

import metier.Entreprise;
import metier.User;



public interface InterfaceEntreprise {
	public void setEnseignant(Entreprise u);
	 public List<Entreprise> getAllEnseignant();
	 public  User LoginEnseignant(String login,String password);
	 public Entreprise getEnseignantById(int id);
	 public void updateEnseignant(Entreprise u);
	 public void delateEnseignant(Entreprise u);
}
