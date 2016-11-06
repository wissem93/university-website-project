package interfaceentity;

import java.util.List;

import metier.Etudiant;

public interface InterfaceEtudiant {

	public void setEtudiant(Etudiant u);
	 public List<Etudiant> getAllEtudiant();
	 public Etudiant getEtudiantById(int id);
	 public boolean LoginEtudiant(String login,String password);
	 public void updateEtudiant(Etudiant u);
	 public void delateEtudiant(Etudiant u);
}
