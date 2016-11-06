package interfaceentity;

import java.util.List;

import metier.Filiere;

public interface InterfaceFiliere {
	 public void setFiliere(Filiere c);
	 public List<Filiere> getAllFiliere();
	 public Filiere getFiliereById(int id);
	 public void updateFiliere(Filiere u);
	 public void delateFiliere(Filiere u);
}
