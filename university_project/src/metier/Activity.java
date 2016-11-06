package metier;

public class Activity {
private int idactivity;
private int idclub;
private String nom;
private String description;
public int getIdclub() {
	return idclub;
}
public void setIdclub(int idclub) {
	this.idclub = idclub;
}
public Activity(String nom, String description) {
	super();
	this.nom = nom;
	this.description = description;
}
public Activity() {
	super();
}

public int getIdactivity() {
	return idactivity;
}
public void setIdactivity(int idactivity) {
	this.idactivity = idactivity;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
}
