package metier;

public class Etudiant  extends User{
private int	idetudiant	;
private int	idclass;
private int idnote;

public int getIdetudiant() {
	return idetudiant;
}
public void setIdetudiant(int idetudiant) {
	this.idetudiant = idetudiant;
}

public int getIdclass() {
	return idclass;
}
public void setIdclass(int idclass) {
	this.idclass = idclass;
}

public Etudiant() {
	super();
}
public int getIdnote() {
	return idnote;
}
public void setIdnote(int idnote) {
	this.idnote = idnote;
}
}
