package interfaceentity;

import java.util.List;

import metier.Enseignant;
import metier.EnseignantSuivis;
import metier.Etudiant;

public interface InterfaceEnseignantSuivis {
	public void setEnseignantSuivis(EnseignantSuivis c);

	public List<Enseignant> getEnseignantByEtudiant(int idEtudiant);

	public List<Etudiant> getEtudiantByEnseignant(int idEnseignant);

	public EnseignantSuivis getEnseignantSuivisById(int idetudiant, int idEnseignant);

	public void delateEnseignantSuivis(EnseignantSuivis u);

}
