package metier;

public class Admin extends User {
private int idAdmin;
private String login;
public int getIdAdmin() {
	return idAdmin;
}
public void setIdAdmin(int idAdmin) {
	this.idAdmin = idAdmin;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public Admin() {
	super();
}
public Admin(String login) {
	super();
	this.login = login;
}

}
