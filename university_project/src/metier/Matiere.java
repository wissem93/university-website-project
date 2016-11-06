package metier;

public class Matiere {
private int	idmatiere;
private String NomMatiere;
public Matiere() {
	super();
}
public Matiere(String nomMatiere) {
	super();
	NomMatiere = nomMatiere;
}
public int getIdmatiere() {
	return idmatiere;
}
public void setIdmatiere(int idmatiere) {
	this.idmatiere = idmatiere;
}
public String getNomMatiere() {
	return NomMatiere;
}
public void setNomMatiere(String nomMatiere) {
	NomMatiere = nomMatiere;
}

}
