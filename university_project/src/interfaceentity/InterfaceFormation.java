package interfaceentity;

import java.util.List;

import metier.Formation;

public interface InterfaceFormation {
	 public void setFormation(Formation s);
	 public List<Formation> getAllFormation();
	 public Formation getFormationById(int id);
	 public void updateFormation(Formation u);
	 public void delateFormation(Formation u);



}
