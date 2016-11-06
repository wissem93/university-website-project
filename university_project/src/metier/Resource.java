package metier;

public class Resource {
private int 	idresource;
private String nom;
private String urlRsource;
private String description;
private String type;

public int getIdresource() {
	return idresource;
}
public void setIdresource(int idresource) {
	this.idresource = idresource;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public Resource() {
	super();
}
public Resource(String nom) {
	super();
	this.nom = nom;
}


public String getUrlRsource() {
	return urlRsource;
}
public void setUrlRsource(String urlRsource) {
	this.urlRsource = urlRsource;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
}

