package metier;

import java.sql.Date;

public class Cours {
private int idcours;
private int codeMatiere;
private String nomCours;
private String urlcours;
private String descriptionCours;
private Date dateDepotCours;
public Cours(int codeMatiere, String nomCours, String urlcours, String descriptionCours, Date dateDepotCours) {
	super();
	this.codeMatiere = codeMatiere;
	this.nomCours = nomCours;
	this.urlcours = urlcours;
	this.descriptionCours = descriptionCours;
	this.dateDepotCours = dateDepotCours;
}
public Cours() {
	super();
}
public int getIdcours() {
	return idcours;
}
public void setIdcours(int idcours) {
	this.idcours = idcours;
}
public int getCodeMatiere() {
	return codeMatiere;
}
public void setCodeMatiere(int codeMatiere) {
	this.codeMatiere = codeMatiere;
}
public String getNomCours() {
	return nomCours;
}
public void setNomCours(String nomCours) {
	this.nomCours = nomCours;
}
public String getUrlcours() {
	return urlcours;
}
public void setUrlcours(String urlcours) {
	this.urlcours = urlcours;
}
public String getDescriptionCours() {
	return descriptionCours;
}
public void setDescriptionCours(String descriptionCours) {
	this.descriptionCours = descriptionCours;
}
public Date getDateDepotCours() {
	return dateDepotCours;
}
public void setDateDepotCours(Date dateDepotCours) {
	this.dateDepotCours = dateDepotCours;
}

}
