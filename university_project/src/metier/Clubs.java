package metier;

public class Clubs {
	private int idclub;
	private String nom;
	private String caractere;
	private int idActivity;
	private int idencadreur;

	public Clubs() {
		super();
	}

	public Clubs(String nom, String caractere) {
		super();
		this.nom = nom;
		this.caractere = caractere;
	}

	public int getIdclub() {
		return idclub;
	}

	public void setIdclub(int idclub) {
		this.idclub = idclub;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCaractere() {
		return caractere;
	}

	public void setCaractere(String caractere) {
		this.caractere = caractere;
	}

	public int getIdActivity() {
		return idActivity;
	}

	public void setIdActivity(int idActivity) {
		this.idActivity = idActivity;
	}

	public int getIdencadreur() {
		return idencadreur;
	}

	public void setIdencadreur(int idencadreur) {
		this.idencadreur = idencadreur;
	}

}
