package interfaceentity;

import java.util.List;

import metier.Classe;

public interface InterfaceClasse {

	 public void setClasse(Classe c);
	 public List<Classe> getAllClasse();
	 public Classe getClasseById(int id);
	 public void updateClasse(Classe u);
	 public void delateClasse(Classe u);
}
