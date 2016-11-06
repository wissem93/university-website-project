package metier;

public class Filiere {
private int idfiliere;
private String nomFiliere	;
public Filiere(String nomFiliere) {
	super();
	this.nomFiliere = nomFiliere;
}
public int getIdfiliere() {
	return idfiliere;
}
public void setIdfiliere(int idfiliere) {
	this.idfiliere = idfiliere;
}
public String getNomFiliere() {
	return nomFiliere;
}
public void setNomFiliere(String nomFiliere) {
	this.nomFiliere = nomFiliere;
}
public Filiere() {
	super();
}
}
