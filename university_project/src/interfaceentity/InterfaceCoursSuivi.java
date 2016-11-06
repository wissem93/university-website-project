package interfaceentity;

import java.util.List;

import metier.Cours;
import metier.CoursSuivis;
import metier.Etudiant;

public interface InterfaceCoursSuivi {
	
	 public void setCoursSuivis(CoursSuivis c);
	 public List<Cours> getCoursByEtudiant(int idEtudiant);
	 public List<Etudiant> getCoursByCours(int idcours);
	 public CoursSuivis getCoursSuivisById(int idetudiant,int idcour);
	 public void delateCoursSuivis(CoursSuivis u);
}
