package metier;

public class Classe {
private int idclasse;
private int idfiliere;
private String nomClasse;
private int idEmploit;
public int getIdclasse() {
	return idclasse;
}
public void setIdclasse(int idclasse) {
	this.idclasse = idclasse;
}
public int getIdfiliere() {
	return idfiliere;
}
public void setIdfiliere(int idfiliere) {
	this.idfiliere = idfiliere;
}
public String getNomClasse() {
	return nomClasse;
}
public void setNomClasse(String nomClasse) {
	this.nomClasse = nomClasse;
}
public Classe(String nomClasse) {
	super();
	this.nomClasse = nomClasse;
}
public Classe() {
	super();
}

public int getIdEmploit() {
	return idEmploit;
}
public void setIdEmploit(int idEmploit) {
	this.idEmploit = idEmploit;
}
}
