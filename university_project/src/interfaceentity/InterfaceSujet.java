package interfaceentity;

import java.util.List;

import metier.Sujet;

public interface InterfaceSujet {
	 public void setSujet(Sujet s);
	 public List<Sujet> getAllSujet();
	 public Sujet getSujetById(int id);
	 public void updateSujet(Sujet u);
	 public void delateSujet(Sujet u);

}
