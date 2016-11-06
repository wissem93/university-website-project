package metier;

public class Sujet {
private int	idSujet;
private String 	titre;
private int iduser;
private String description;
private String categorie;
public int getIdSujet() {
	return idSujet;
}
public void setIdSujet(int idSujet) {
	this.idSujet = idSujet;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public int getIduser() {
	return iduser;
}
public void setIduser(int iduser) {
	this.iduser = iduser;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCategorie() {
	return categorie;
}
public void setCategorie(String categorie) {
	this.categorie = categorie;
}
public Sujet(String titre, int iduser, String description, String categorie) {
	super();
	this.titre = titre;
	this.iduser = iduser;
	this.description = description;
	this.categorie = categorie;
}
public Sujet() {
	super();
}
}
