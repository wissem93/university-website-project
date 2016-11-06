package interfaceentity;

import java.util.List;

import metier.Matiere;

public interface InterfaceMatiere {
	 
	 public void setMatiere(Matiere s);
	 public List<Matiere> getAllMatiere();
	 public Matiere getMatiereById(int id);
	 public void updateMatiere(Matiere u);
	 public void delateMatiere(Matiere u);

	
	
	
}
