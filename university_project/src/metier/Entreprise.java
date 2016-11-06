package metier;

public class Entreprise extends User {
public int identreprise;
public String adresseEntreprise;

public Entreprise(String nomuser, String prenom, String adresseEntreprise) {
	super(nomuser, prenom);
	this.adresseEntreprise = adresseEntreprise;
}
public int getIdentreprise() {
	return identreprise;
}

public void setIdentreprise(int identreprise) {
	this.identreprise = identreprise;
}
public String getAdresseEntreprise() {
	return adresseEntreprise;
}
public void setAdresseEntreprise(String adresseEntreprise) {
	this.adresseEntreprise = adresseEntreprise;
}
}
