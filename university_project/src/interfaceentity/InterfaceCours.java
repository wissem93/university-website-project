package interfaceentity;

import java.util.List;

import metier.Cours;

public interface InterfaceCours {
	 public void setCours(Cours c);
	 public List<Cours> getAllCours();
	 public Cours getCoursById(int id);
	 public List<Cours> getCoursByEnseignant(int id);
	 public void updateCours(Cours u);
	 public void delateCours(Cours u);
}
