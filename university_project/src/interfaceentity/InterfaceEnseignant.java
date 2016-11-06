package interfaceentity;

import java.util.List;

import metier.Enseignant;

public interface InterfaceEnseignant {
	public void setEnseignant(Enseignant u);
	 public List<Enseignant> getAllEnseignant();
	 public Enseignant getEnseignantById(int id);
	 public void updateEnseignant(Enseignant u);
	 public void delateEnseignant(Enseignant u);
}
