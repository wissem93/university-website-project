package metier;


public class User  {

private int iduser;
private String nomuser;
private String prenom;
private String login;
private String password;
private String telephone;
private String email;

public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getIduser() {
	return iduser;
}
public void setIduser(int iduser) {
	this.iduser=iduser;
}
public String getNomuser() {
	return nomuser;
}
public void setNomuser(String nomuser) {
	this.nomuser = nomuser;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public User(String nomuser, String prenom) {
	super();
	this.nomuser = nomuser;
	this.prenom = prenom;
}
public User() {
	super();
}

}
