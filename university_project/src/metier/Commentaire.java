package metier;

public class Commentaire {
private int idcommentaire;
private int iduser;
private String textCom;
private int idSujet;
public Commentaire() {
	super();
	// TODO Auto-generated constructor stub
}
public Commentaire(int iduser, String textCom, int idSujet) {
	super();
	this.iduser = iduser;
	this.textCom = textCom;
	this.idSujet = idSujet;
}
public int getIdcommentaire() {
	return idcommentaire;
}
public void setIdcommentaire(int idcommentaire) {
	this.idcommentaire = idcommentaire;
}
public int getIduser() {
	return iduser;
}
public void setIduser(int iduser) {
	this.iduser = iduser;
}
public String getTextCom() {
	return textCom;
}
public void setTextCom(String textCom) {
	this.textCom = textCom;
}
public int getIdSujet() {
	return idSujet;
}
public void setIdSujet(int idSujet) {
	this.idSujet = idSujet;
}
}
