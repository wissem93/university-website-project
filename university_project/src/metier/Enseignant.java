package metier;

public class Enseignant extends User {
private int idenseignant;
private int idmatier;
private int idemplois;
private String gradeEnseignant;
public int getIdenseignant() {
	return idenseignant;
}
public void setIdenseignant(int idenseignant) {
	this.idenseignant = idenseignant;
}
public int getIdmatier() {
	return idmatier;
}
public void setIdmatier(int idmatier) {
	this.idmatier = idmatier;
}
public int  getIdemplois() {
	return idemplois;
}
public void setIdemplois(int idemplois) {
	this.idemplois = idemplois;
}
public String getGradeEnseignant() {
	return gradeEnseignant;
}
public void setGradeEnseignant(String gradeEnseignant) {
	this.gradeEnseignant = gradeEnseignant;
}


}
